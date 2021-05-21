
package org.quipa.dialogo;

class DialogoError extends RuntimeException {
  
  public final int line;
  public final int position;
  public final String message;
  
  DialogoError(int line, int position, String message) {
    super(message);
    this.line = line;
    this.position = position;
    this.message = message;
  }
  
  public String report(String source) {
    
    int lineStart = source.lastIndexOf('\n', position);
    int lineEnd =   source.indexOf('\n', position);
    lineStart = lineStart == -1 ? 0 : lineStart;
    lineEnd = lineEnd == -1 ? source.length() : lineEnd;
    
    int column = position - lineStart;
    
    String code = source.substring(lineStart, lineEnd);
    
    String errorPointer = "\n\t" + " ".repeat(column) + "^";
    
    String reportMessage = (
      message + 
      " (na linha " + line + ", coluna " + column + "):\n\t" +
      code + errorPointer);
      
    return reportMessage;
  }
  
}
