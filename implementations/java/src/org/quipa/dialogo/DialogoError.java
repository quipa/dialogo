
package org.quipa.dialogo;

class DialogoError extends RuntimeException {
  
  public final String message;
  public final int start;
  public final int end;
  
  DialogoError(int start, int end, String message) {
    super(message);
    this.message = message;
    this.start = start;
    this.end = end;
  }
  
  public void report(String source) {
    
    String previous = source.substring(0, start);
    String thing = source.substring(start, end);
    String codeLine = source.substring(
      previous.lastIndexOf('\n'), source.indexOf('\n', end));
    
    int line = (int)previous
      .chars().filter(ch -> ch == '\n')
      .count();
    int column = previous.lastIndexOf('\n') - start;
    
    String reportMessage = (
      "Na linha" + line +
      ", coluna " + column +
      ", onde " + thing + ":\n\t" +
      message
    );
      
    System.err.println(reportMessage);
  }
  
}
