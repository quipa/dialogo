
package org.quipa.dialogo.gramatica;

enum Preposicao implements Palavra {
   // Essencial
  ANTE,
  COM,
  DE, DESDE,
  EM, 
  PARA, PERANTE,
  SEM,
  SOB,
  TRAS,
  // Acidental (toda preposição que for ambígua
  A, APOS, ATE,
  // COMO, Infopédia e Gramática moderna não, Priberam sim
  CONFORME, CONTRA,
  DURANTE,
  EXCETO, ENTRE,
  FORA,
  MAIS, MENOS,
  POR,
  QUE,
  SALVO, SENAO, SOBRE,
  MEDIANTE
  // Acrescentar Locuções
  ;
  
  public final Flexao.Pessoa  pessoa = Flexao.Pessoa.INVARIAVEL;
  public final Flexao.Genero  gênero = Flexao.Genero.INVARIAVEL;
  public final Flexao.Numero  número = Flexao.Numero.INVARIAVEL;
  
}
