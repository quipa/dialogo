
package org.quipa.dialogo.gramatica;


class Adjetivo implements Palavra {
  
  enum Grau {
    NORMAL,
    COMPARATIVO,
    SUPERLATIVO_ABSOLUTO,
    SUPERLATIVO_RELATIVO
  }
  
  // public final String texto;
  public final Flexao.Pessoa  pessoa = Flexao.Pessoa.INVARIAVEL;
  public final Flexao.Genero  gênero;
  public final Flexao.Numero  número;
  public final Adjetivo.Grau  grau;
  
  // Adjetivo de 2 gêneros
  Adjetivo(Flexao.Numero número) {
    this.gênero = Flexao.Genero.INVARIAVEL;
    this.número = número;
    this.grau   = Adjetivo.Grau.NORMAL;
  }
  
  Adjetivo(
      // String texto,
      Flexao.Genero gênero,
      Flexao.Numero número,
      Adjetivo.Grau grau) {
    // this.texto  = texto;
    this.gênero = gênero;
    this.número = número;
    this.grau   = grau;
  }
  
}
