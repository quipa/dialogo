
package org.quipa.dialogo;

class Interpreter {
  
  private final Mode mode;
  
  Interpreter(Mode mode) {
    this.mode = mode;
    // this.environment = new Environment();
  }
  
  public String call(String source) throws DialogoErrors {
    return analyser(mode, source).call();
  }
  
  private Phase analyser(Mode mode, String source) {
    switch(mode) {
      case MORPHOLOGICAL: return new Morpheme.Analyser(source);
      case LEXICAL:
        throw new RuntimeException(mode + " not implemented.");
      case SYNTATICAL:
        throw new RuntimeException(mode + " not implemented.");
      case SEMANTIC:
        throw new RuntimeException(mode + " not implemented.");
      default:
        return new Morpheme.Analyser(source);
    }
  }
  
  /*
  private String call(Mode.SEMANTIC, String source)
      throws DialogoErrors {
    TODO: Semantic analysis.
    Sememe.Analyser sem = new Sememe.Analyser(syntagmas);
    * List<Sememe> sememes = sem.analyse();
    if (sem.hadError) {
      return Dialogo.Status.RUNTIME_ERROR;
    }
    return null;
  }
  */
  
}
