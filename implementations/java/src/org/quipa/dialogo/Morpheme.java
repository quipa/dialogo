/*
 * TODO: Finish implementing proper Iterable, for now just hack
 */

package org.quipa.dialogo;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Morpheme {

  final Morpheme.Type type;
  final String text;
  final int position;
  
  private static final String diacritics;
  private static final String symbols;
    
  static {
    diacritics = "çãõáéíóúàèìòùâêôÇÃÕÁÉÍÓÚÀÈÌÒÙÂÊÔ";
    symbols =  "+-*/=<>%~^&$@|";
  }
  
  Morpheme(Morpheme.Type type, String text, int position) {
    this.type = type;
    this.text = text;
    this.position = position;
  }
  
  public String toString() {
    return type + " " + text;
  }
  
  enum Type {
    LEFT_ROUND_BRACKET, RIGHT_ROUND_BRACKET,
    LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET,
    LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET,

    DOT, COMMA, COLON, SEMICOLON,
    QUESTION_MARK, EXCLAMATION_MARK,
    BACKSLASH, BACKQUOTE,
    
    SPACE,
    
    STRING, COMMENT, WORD, NUMBER, SYMBOL,
    
    ERROR,
    EOF
  }
  
  static class Analyser implements Iterable<Morpheme> {
    
    public boolean hadError = false;
    private final String source;
    private final List<Morpheme> morphemes = new ArrayList<>();
    private int start = 0;
    private int current = 0;
    
    Analyser(String source) {
      this.source = source;
    }
    
    public Iterator<Morpheme> iterator() {
      return analyse().iterator();
    }
    
    List<Morpheme> analyse() {
      while (!isAtEnd()) {
        try {
          start = current;
          morphemes.add(get(morpheme()));
        } catch (DialogoError e) {
          if (!isAtEnd()) {
            hadError = true;
            e.report(source);
            morphemes.add(new Morpheme(Morpheme.Type.ERROR, "", current));
            advance();
          }
        }
      }
      
      morphemes.add(new Morpheme(Morpheme.Type.EOF, "", current));
      return morphemes;
    }
    
    /* Morphemes */
    
    private Morpheme.Type morpheme() {
      char c = advance();
      switch (c) {
        
        // Delimiters.
        case '[': return Morpheme.Type.LEFT_SQUARE_BRACKET;
        case ']': return Morpheme.Type.RIGHT_SQUARE_BRACKET;
        case '{': return Morpheme.Type.LEFT_CURLY_BRACKET;
        case '}': return Morpheme.Type.RIGHT_CURLY_BRACKET;
        case '(': return Morpheme.Type.LEFT_ROUND_BRACKET;
        case ')': return Morpheme.Type.RIGHT_ROUND_BRACKET;
        
        // Punctuation.
        case '.': return Morpheme.Type.DOT;
        case '?': return Morpheme.Type.QUESTION_MARK;
        case '!': return Morpheme.Type.EXCLAMATION_MARK;
        case ',': return Morpheme.Type.COMMA;
        case ':': return Morpheme.Type.COLON;
        case ';': return Morpheme.Type.SEMICOLON;
        case '`': return Morpheme.Type.BACKQUOTE;
        case '\\': return Morpheme.Type.BACKSLASH;
        
        // Whitespace.
        case ' ':
        case '\r':
        case '\t':
        case '\n':
          return space();
        
        // Strings.
        case '\'': return string('\'');
        case '"': return string('"');
        case '«': return string('»');
        case '#': return comment();
        
        default:
          if (isDigit(c)) {
            return number();
          } else if (isLetter(c)) {
            return word();
          } else if (isSymbol(c)) {
            return Morpheme.Type.SYMBOL;
          }
          throw new DialogoError(start, current, "Não reconheço o caratere " + c);
      }
    }
    
    private Morpheme.Type space() {
      while (!isAtEnd()) {
        switch (peek()) {
          case ' ' :
          case '\r' :
          case '\t' :
          case '\n' :
            break;
          default:
            return Morpheme.Type.SPACE;
        }
        advance();
      }
      // Should be unreachable
      return null;
    }
    
    private Morpheme.Type string(char quote) {
      char c;
      while (!isAtEnd()) {
        c = advance();
        if (c == quote) return Morpheme.Type.STRING;
        if (c == '\\') advance();
      }
      
      throw new DialogoError(start, current, "Texto deve terminar com " + quote + ".");
    }
    
    private Morpheme.Type comment() {
      while (!isAtEnd()) {
        switch (peek()) {
          case '#':
            advance();
            return Morpheme.Type.COMMENT;
          case '\\':
            advance();
            break;
        }
        advance();
      }
      
      throw new DialogoError(start, current, "Comentário deve terminar com #.");
    }
    
    private Morpheme.Type word() {
      while (!isAtEnd() && isLetter(peek())) {
        advance();
      }
      return Morpheme.Type.WORD;
    }

    private Morpheme.Type number() {
      while (!isAtEnd() && isDigit(peek())) {
        advance();
      }
      return Morpheme.Type.NUMBER;
    }
    
    /* Predicates */
    
    private boolean isAtEnd() {
      return current >= source.length();
    }
    
    static private boolean isLetter(char c) {
      return (
        (c >= 'a' && c <= 'z') ||
        (c >= 'A' && c <= 'Z') ||
        (Morpheme.diacritics.indexOf(c) != -1)
      );
    }
    
    static private boolean isDigit(char c) {
      return c >= '0' && c <= '9';
    }
    
    static private boolean isSymbol(char c) {
      return Morpheme.symbols.indexOf(c) != -1;
    }
    
    /* Procedures */
    
    private boolean match(char expected) {
      if (isAtEnd()) return false;
      if (source.charAt(current) != expected) return false;
      
      current++;
      return true;
    }
    
    private char peek() {
      if (isAtEnd()) return '\0';
      return source.charAt(current);
    }
    
    private char peekNext() {
      if (current + 1 >= source.length()) return '\0';
      return source.charAt(current + 1);
    }
    
    private char advance() {
      return source.charAt(current++);
    }
    
    private Morpheme get(Morpheme.Type type) {
      String text = source.substring(start, current);
      return new Morpheme(type, text, start);
    }
  
  }
  
}
