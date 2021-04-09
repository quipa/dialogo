
package org.quipa.dialogo;

enum MorphemeType {
  // Delimiter.
  LEFT_ROUND_BRACKET, RIGHT_ROUND_BRACKET,
  LEFT_CURLY_BRACKET, RIGHT_CURLY_BRACKET,
  LEFT_SQUARE_BRACKET, RIGHT_SQUARE_BRACKET,

  // Punctuation.
  DOT, COMMA, COLON, SEMICOLON,
  QUESTION_MARK, EXCLAMATION_MARK,
  SLASH, HASH,

  // Items.
  WORD, SYMBOL, IDENTIFIER,
  NUMBER, STRING,

  SPACE,
  EOF
}
