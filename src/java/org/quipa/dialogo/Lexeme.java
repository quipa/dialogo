
package org.quipa.dialogo;


// FIXME: bug with whitespace, sometimes comes out repeated

// TODO: need to distinguish between
// escapable ('\\' "\\") == one \
// and raw text («\\») == two \
// important for regexes (big problem in java which doesn't have it)

package org.quipa.dialogo;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Stack;
mport java.util.stream.Collectors;

class Lexeme {
  
  enum Type {
    SPACE,
    NULL, BOOLEAN, TEXT,
    BINARY_INT, OCTAL_INT, DECIMAL_INT, HEXADECIMAL_INT, 
    RATIONAL, REAL,
    IDENTIFIER,
    PUNCTUATION, 
    SPECIAL, COMMENT,
    EOF
  }
  
  final Lexeme.Type type;
  final morpheme;
  
  private Lexeme() {}
  
  Lexeme(Lexeme.Type type, Morpheme morpheme) {
    this.type = type;
    this.morpheme = morpheme;
  }
  
  public String toString() {
    if (type == Lexeme.Type.SPACE)
      return type.toString();
    else
      return type + " " + morpheme.text;
  }
  
  static class Special extends Lexeme {
    
    final Lexeme.Type type;
    final List<Morpheme> morphemes;
    private final text;
    
    Special(Lexeme.Type type, List<Morpheme> morphemes) {

      this.type = type;
      this.text = morphemes.stream()
        .map( m -> m.text )
        .collect(Collectors.joining())
      
      Morpheme m = morphemes.get(0);
      this.morphemes = new ArrayList(morphemes);
    }
    
  }
  
  static class Analyser implements Enumeration<Lexeme> {
    
    private final Morpheme.Analyser source;
    private final Morpheme current;
    private final Stack<Morpheme> stack;
    
    Analyser(Morpheme.Analyser source) {
      this.source = source;
    }
    
    public Iterator<Lexeme> iterator() {
      return this;
    }
    
    public boolean hasMoreElements() {
      return !source.hasMoreElements();
    }
    
    public Lexeme nextElement() {
      stack = new Stack<>();
      return get(lexeme());
    }
    
    private Lexeme get(Lexeme.Type type) {
      if stack.size() > 1 {
        return Lexeme.Special(type, stack)
      else {
        return new Lexeme(type, stack.get(0));
    }
    
    // Lexemes
    
    private Lexeme.Type lexeme() throws DialogoError {
      Morpheme m = advance();
      
      /* NOTE
       * Words and numbers should be more common
       * so matching them first should be faster (hopefully).
       */
        
      switch (m) {
        WORD, NUMBER, SYMBOL,
    case TEXT, IDENTIFIER,
    case LEFT_BRACKET:
    case RIGHT_BRACKET:
    case LEFT_BRACE:
    case RIGHT_BRACE:
    case LEFT_PAREN:
    case RIGHT_PAREN:

    case DOT:,
    case QUESTION_MARK:, EXCLAMATION_MARK,
    COMMA, SEMICOLON, COLON,
    PUNCTUATION
    
    SPACE, COMMENT,
    
    EOF
        
        default:
          if (isSymbol(c)) return Morpheme.Type.SYMBOL;
          throw error("Não sei o que é " + c + ".");
      }
    }
    
    
    
    private Lexeme.Type word() {
      
    }
    
    private Lexeme.Type operator() {
      
    }
    
    private Lexeme.Type special() {
      
    }
    
    private DialogoError error(String message) {
      Morpheme m = stack.get(0)
      DialogoError e = new DialogoError(m.line, m.position, message);
      return e;
    }
    
    // Analyzer state methods
    
    private Morpheme.Type peek() {
      return stack.peek().type;
    }
    
    private Morpheme.Type advance() {   
      Morpheme.Type m ;
      
      if (!source.hasMoreElements()) {
        return Morpheme.Type.EOF 
      } else {
        m = stack.peek().type
        stack.push(source.nextElement())
        return m
      }
    }
    
    private boolean match(Lexeme.Type expected) {
      if (stack.peek().type == expected) {
        advance();
        return true;
      } else {
        return false;
      }
    }
  
  }
  
}
