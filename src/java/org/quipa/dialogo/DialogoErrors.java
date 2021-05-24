
package org.quipa.dialogo;

import java.util.Queue;
import java.util.Iterator;

class DialogoErrors extends RuntimeException implements Iterable {
  
  public Queue<DialogoError> errors;
  
  DialogoErrors(Queue<DialogoError> errors) {
    this.errors = errors;
  }
  
  public Iterator<DialogoError> iterator() {
    return errors.iterator();
  }
  
}
