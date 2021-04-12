
package org.quipa.dialogo.gramatica;


interface Conjuncao extends Palavra {
  
  // Acrescentar Locuções conjuncionais
  
  enum Coordenativa implements Conjuncao {
    ASSIM, CONTUDO, E, LOGO, MAS, NEM, OU,
    PORQUANTO, POIS, PORÉM, PORQUE, PORTANTO, QUE, TAMBÉM, TODAVIA;
    
    public final Flexao.Pessoa  pessoa = Flexao.Pessoa.INVARIAVEL;
    public final Flexao.Genero  gênero = Flexao.Genero.INVARIAVEL;
    public final Flexao.Numero  número = Flexao.Numero.INVARIAVEL;
    
  }
  
  enum Subordinativa implements Conjuncao {
    APENAS, CASO, COMO, CONFORME, CONQUANTO, EMBORA, ENQUANTO, MAL, 
    POIS, PORQUANTO, QUANTO, QUE, SE, SENÃO;
    
    public final Flexao.Pessoa  pessoa = Flexao.Pessoa.INVARIAVEL;
    public final Flexao.Genero  gênero = Flexao.Genero.INVARIAVEL;
    public final Flexao.Numero  número = Flexao.Numero.INVARIAVEL;
    
  }
  
}
