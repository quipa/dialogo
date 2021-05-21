
package org.quipa.dialogo.gramatica;


class Nome implements Palavra {
  
  enum Grau {
    NEUTRO,
    AUMENTATIVO,
    DIMINUTIVO
  }
  
  // public final String texto;
  public final Flexao.Pessoa  pessoa = Flexao.Pessoa.INVARIAVEL;
  public final Flexao.Numero  número;
  public final Flexao.Genero  gênero;
  public final Nome.Grau    grau;
  
  Nome(
      // String texto,
      Flexao.Numero número,
      Flexao.Genero gênero,
      Nome.Grau grau) {
    // this.texto  = texto;
    this.número = número;
    this.gênero = gênero;
    this.grau   = grau;
  }
  
}
