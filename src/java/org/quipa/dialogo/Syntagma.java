
package org.quipa.dialogo;

import java.util.Enumeration;

class Syntagma {
  
/*
  private String call(Mode.SYNTATICAL, String source)
      throws DialogoErrors {
    var errors = new ArrayDeque<DialogoError>();
    
    TODO: Syntatic analyis.
    Syntagma.Analyser syn = new Syntax.Analyser(lexemes);
    List<Syntagma> syntagmas = syn.analyse();
    if (syn.hadError) {
      return Dialogo.Status.COMPILE_ERROR;
    }

    return null;
  }
  */
  
  static class Analyser implements Enumeration<Syntagma>, Phase {
  
    public String call() throws DialogoErrors {
      /* TODO
        var results = new ArrayDeque<Morpheme>();
        var errors = new ArrayDeque<DialogoError>();
        
        while (hasMoreElements()) {
          try {
            results.add(nextElement());
          } catch (DialogoError e) {
            errors.add​(e);
          }
        }
        
        if (errors.size() != 0) {
          throw new DialogoErrors(errors);
        } else {
          return results.stream()
            .map(m -> m.toString())
            .collect(Collectors.joining("\n"));
        }
      }
      */
      throw new RuntimeException("Syntatic analysis phase not implemented.");
    }
    
    public boolean hasMoreElements() {
      throw new RuntimeException("Syntatic analysis phase not implemented.");
    }
    
    public Syntagma nextElement() {
      throw new RuntimeException("Syntatic analysis phase not implemented.");
    }
    
  }
  
}
