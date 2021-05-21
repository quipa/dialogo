
// FIXME: bug with whitespace, sometimes comes out repeated

// TODO: need to distinguish between
// escapable ('\\' "\\") == one \
// and raw text («\\») == two \
// important for regexes (big problem in java which doesn't have it)

package org.quipa.dialogo;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


class Morpheme {

  final Morpheme.Type type;
  final String text;
  final int line;
  final int position;
  
  private static final String diacritics;
  private static final String symbols;
    
  static {
    diacritics  = "çãõáéíóúàèìòùâêôÇÃÕÁÉÍÓÚÀÈÌÒÙÂÊÔ";
    symbols     = "+-*/=<>%|&$@_~^#\\";
  }
  
  Morpheme(Morpheme.Type type, String text, int line, int position) {
    this.type = type;
    this.text = text;
    this.line = line;
    this.position = position;
  }
  
  public String toString() {
    if (type == Morpheme.Type.SPACE)
      return type.toString();
    else
      return type + " " + text;
  }
  
  enum Type {
    LEFT_BRACKET, RIGHT_BRACKET,
    LEFT_BRACE,   RIGHT_BRACE,
    LEFT_PAREN,   RIGHT_PAREN,

    DOT, QUESTION_MARK, EXCLAMATION_MARK,
    COMMA, SEMICOLON, COLON,
    
    SPACE,
    
    WORD, NUMBER, SYMBOL,
    TEXT, IDENTIFIER, COMMENT
  }
  
  static class Analyser implements
      Iterable<Morpheme>,
      Iterator<Morpheme> {
    private final String source;
    private int line = 1;
    private int start = 0;
    private int current = 0;
    
    Analyser(String source) {
      this.source = source;
    }
    
    public Iterator<Morpheme> iterator() {
      return this;
    }
    
    public boolean hasNext() {
      return !isAtEnd() ;
    }
    
    public Morpheme next() {
      start = current;
      return get(morpheme());
    }
    
    private Morpheme get(Morpheme.Type type) {
      String text = source.substring(start, current);
      return new Morpheme(type, text, line, start);
    }
    
    // Morphemes
    
    private Morpheme.Type morpheme() throws DialogoError {
      char c = advance();
      
      /* NOTE
       * Words and numbers should be more common
       * so matching them first should be faster (hopefully).
       */
      
      if (isLetter(c)) return word();
      if (isDigit(c)) return number();
      if (isWhitespace(c)) return whitespace();
      switch (c) {
        
        // Strings.
        case '\'': return string('\'');
        case '"': return string('"');
        case '«': return string('»');
        case '`': return identifier();
        
        // Brackets and comments
        case '[': return match('/') ? bracketComment()
                                    : Morpheme.Type.LEFT_BRACKET;
        case '{': return match('/') ? braceComment()
                                    : Morpheme.Type.LEFT_BRACE;
        case '(': return match('/') ? parenComment()
                                    : Morpheme.Type.LEFT_PAREN;
        case '/': return match('/') ? lineComment()
                                    : Morpheme.Type.SYMBOL;
        
        case ']': return Morpheme.Type.RIGHT_BRACKET;
        case '}': return Morpheme.Type.RIGHT_BRACE;
        case ')': return Morpheme.Type.RIGHT_PAREN;
        case '.': return Morpheme.Type.DOT;
        case '?': return Morpheme.Type.QUESTION_MARK;
        case '!': return Morpheme.Type.EXCLAMATION_MARK;
        case ',': return Morpheme.Type.COMMA;
        case ':': return Morpheme.Type.COLON;
        case ';': return Morpheme.Type.SEMICOLON;
        
        default:
          if (isSymbol(c)) return Morpheme.Type.SYMBOL;
          throw error("Não sei o que é " + c + ".");
      }
    }
    
    private Morpheme.Type word() {
      while (isLetter(peek())) {
        advance();
      }
      return Morpheme.Type.WORD;
    }

    private Morpheme.Type number() {
      while (isDigit(peek())) {
        advance();
      }
      return Morpheme.Type.NUMBER;
    }
    
    private Morpheme.Type whitespace() {
      while (isWhitespace(peek())) {
        if (check('\n')) line++;
        advance();
      }
      
      //loop: for (char c = peek(); c != '\0'; c = advance()) {
        //switch (c) {
          //case '\n': line++;
          //case ' ': case '\r': case '\t': break;
          //default: break loop; // FIXME: this is consuming an extra character
        //}
      //}
      return Morpheme.Type.SPACE;
    }
    
    private Morpheme.Type string(char quote) throws DialogoError {
      for (char c = peek(); c != '\0'; c = advance()) {
        switch (c) {
          case '\\': if (match(quote)); break;
          case '\n': line++; break;
          default: if (match(quote)) return Morpheme.Type.TEXT;
        }
      }
      throw error("Falta '" + quote + "' para acabar o texto.");
    }
    
    private Morpheme.Type identifier() throws DialogoError {
      boolean p = false;
      boolean w = false;
      for (char c = peek(); c != '\0'; c = advance()) {
        switch (c) {
          case '\\': match('`'); break;
          case '\n': line++; p = true;
          case ' ': case '\r': case '\t': break;
          case '`':
            if (p) throw error(
              "Identificador extenso não pode ter parágrafos");
            else if (!w) throw error(
              "Identificador extenso só tem espaço ou escapes");
            else return Morpheme.Type.IDENTIFIER;
          default: w = true;
        }
      }
      
      throw error("Falta '`' para acabar o identificador extenso.");
    }
    
    private Morpheme.Type lineComment() {
      for (char c = peek(); c != '\0'; c = advance()) {
        if (check('\n')) {
          break;
        }
      }
      return Morpheme.Type.COMMENT;
    }
    
    private Morpheme.Type bracketComment() throws DialogoError {
      int stack = 1;
      for (char c = peek(); stack > 0; c = advance()) {
        switch (c) {
          case '/': if (check(']')) stack--; break;
          case '[': if (match('/')) stack++; break;
          case '\\': if (match('[') || match(']') || match('/')); break;
          case '\n': line++; break;
          case '\0':
            throw error("Falta '/]' para acabar o comentário.");
        }
      }
      return Morpheme.Type.COMMENT;
    }
    
    private Morpheme.Type braceComment() throws DialogoError {
      int stack = 1;
      for (char c = peek(); stack > 0; c = advance()) {
        switch (c) {
          case '/': if (check('}')) stack--; break;
          case '{': if (match('/')) stack++; break;
          case '\\': if (match('{') || match('}') || match('/')); break;
          case '\n': line++; break;
          case '\0':
            throw error("Falta '/}' para acabar o comentário.");
        }
      }
      return Morpheme.Type.COMMENT;
    }
    
    private Morpheme.Type parenComment() throws DialogoError {
      int stack = 1;
      for (char c = peek(); stack > 0; c = advance()) {
        switch (c) {
          case '/': if (check(')')) stack--; break;
          case '(': if (match('/')) stack++; break;
          case '\\': if (match('(') || match(')') || match('/')); break;
          case '\n': line++; break;
          case '\0':
            throw error("Falta '/)' para acabar o comentário.");
        }
      }
      return Morpheme.Type.COMMENT;
    }
    
    private DialogoError error(String message) {
      DialogoError e =  new DialogoError(line, start, message);
      return e;
    }
    
    // Character Predicates
    
    static private boolean isLetter(char c) {
      return (
        (c >= 'a' && c <= 'z') ||
        (c >= 'A' && c <= 'Z') ||
        Morpheme.diacritics.indexOf(c) != -1);
    }
    
    static private boolean isDigit(char c) {
      return c >= '0' && c <= '9';
    }
    
    static private boolean isSymbol(char c) {
      return Morpheme.symbols.indexOf(c) != -1;
    }
    
    static private boolean isWhitespace(char c) {
      switch (c) {
        case '\n':  case ' ': case '\r': case '\t':
          return true;
        default: return false;
      }
    }
    
    // Analyzer state methods
    
    private boolean isAtEnd() {
      return current >= source.length();
    }
    
    private char peek() {
      return isAtEnd() ? '\0' : source.charAt(current);
    }
    
    private char advance() {
      // debug
      // System.out.println("[char] " + peek());
      return isAtEnd() ? '\0' : source.charAt(current++);
    }
    
    private boolean check(char expected) {
      return peek() == expected;
    }
    
    private boolean match(char expected) {
      if (peek() == expected) {
        advance();
        return true;
      } else {
        return false;
      }
    }
  
  }
  
}
