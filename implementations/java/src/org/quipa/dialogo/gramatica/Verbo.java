
package org.quipa.dialogo.gramatica;


class Verbo implements Palavra {

  enum Modo {
    INDICATIVO,
    CONJUNTIVO,
    CONDICIONAL,
    IMPERATIVO
  }

  enum Tempo {
    PRESENTE,
    PRETÉRITO_PERFEITO,
    PRETÉRITO_IMPERFEITO,
    PRETÉRIO_MAIS_QUE_PERFEITO,
    FUTURO
  }

  enum Aspeto {
    PERFETIVO,
    IMPERATIVO,
    HABITUAL,
    GENÉRICO,
    ITERATIVO
  }

  enum Voz {
    ATIVA,
    PASSIVA
  }

  // public final String texto;
  public final Flexao.Pessoa pessoa;
  public final Flexao.Genero  gênero = Flexao.Genero.INVARIAVEL;
  public final Flexao.Numero número;
  public final Verbo.Modo   modo;
  public final Verbo.Tempo  tempo;
  public final Verbo.Aspeto aspeto;
  public final Verbo.Voz    voz;
  
  Verbo(// String  texto,
        Flexao.Numero  número,
        Flexao.Pessoa  pessoa,
        Verbo.Modo    modo,
        Verbo.Tempo   tempo,
        Verbo.Aspeto  aspeto,
        Verbo.Voz     voz) {
    // this.texto  = texto;
    this.pessoa = pessoa;
    this.número = número;
    this.modo   = modo;
    this.tempo  = tempo;
    this.aspeto = aspeto;
    this.voz    = voz;
  }
  
}
