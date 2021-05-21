
package org.quipa.dialogo.gramatica;

import static org.quipa.dialogo.gramatica.Flexao.Pessoa;
import static org.quipa.dialogo.gramatica.Flexao.Genero;
import static org.quipa.dialogo.gramatica.Flexao.Numero;


interface Pronome extends Palavra {
  
  enum Pessoal implements Pronome {
    // Nominativos e alguns oblíquos
    EU(  Pessoa.PRIMEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    TU(  Pessoa.SEGUNDA , Genero.INVARIAVEL, Numero.SINGULAR),
    ELA( Pessoa.TERCEIRA, Genero.FEMININO  , Numero.SINGULAR),
    ELE( Pessoa.TERCEIRA, Genero.MASCULINO , Numero.SINGULAR),
    NOS1(Pessoa.PRIMEIRA, Genero.INVARIAVEL, Numero.PLURAL  ),
    VOS1(Pessoa.SEGUNDA , Genero.INVARIAVEL, Numero.PLURAL  ),
    ELAS(Pessoa.TERCEIRA, Genero.FEMININO  , Numero.PLURAL  ),
    ELES(Pessoa.TERCEIRA, Genero.MASCULINO , Numero.PLURAL  ),
    
    // Acusativos e dativos
    ME  (Pessoa.PRIMEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    TE  (Pessoa.SEGUNDA , Genero.INVARIAVEL, Numero.SINGULAR),
    SE  (Pessoa.TERCEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    A   (Pessoa.TERCEIRA, Genero.FEMININO  , Numero.SINGULAR),
    AS  (Pessoa.TERCEIRA, Genero.FEMININO  , Numero.PLURAL  ),
    O   (Pessoa.TERCEIRA, Genero.MASCULINO , Numero.SINGULAR),
    OS  (Pessoa.TERCEIRA, Genero.MASCULINO , Numero.PLURAL  ),
    LHE (Pessoa.TERCEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    NOS2(Pessoa.PRIMEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    VOS2(Pessoa.SEGUNDA , Genero.INVARIAVEL, Numero.PLURAL  ),
    LHES(Pessoa.TERCEIRA, Genero.INVARIAVEL, Numero.PLURAL  ),
    
    // Oblíquos
    MIM( Pessoa.PRIMEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    TI(  Pessoa.SEGUNDA , Genero.INVARIAVEL, Numero.SINGULAR),
    SI1( Pessoa.TERCEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    SI2(Pessoa.TERCEIRA , Genero.INVARIAVEL, Numero.PLURAL),
    COMIGO(   Pessoa.PRIMEIRA, Genero.INVARIAVEL, Numero.SINGULAR),
    CONTIGO(  Pessoa.SEGUNDA , Genero.INVARIAVEL, Numero.SINGULAR),
    CONOSCO(  Pessoa.PRIMEIRA, Genero.INVARIAVEL, Numero.PLURAL),
    CONVOSCO( Pessoa.SEGUNDA , Genero.INVARIAVEL, Numero.PLURAL);
    
    // Not used for now
    private enum Caso {
      NOMINATIVO,
      ACUSATIVO,
      DATIVO,
      OBLIQUO
    }
    
    // Not used for now
    private enum Forma {
      TONICO,
      ATONICO // Excluídos
    }
    
    public final Pessoa pessoa;
    public final Genero gênero;
    public final Numero número;
    
    Pessoal(
        Pessoa pessoa,
        Genero gênero,
        Numero número) {
      this.pessoa = pessoa;
      this.gênero = gênero;
      this.número = número;
    }
    
  }
  
  enum Demonstrativo implements Pronome {
    ESTA(   Genero.FEMININO,  Numero.SINGULAR),
    ESTAS(  Genero.FEMININO,  Numero.PLURAL  ),
    ESTE(   Genero.MASCULINO, Numero.SINGULAR),
    ESTES(  Genero.MASCULINO, Numero.PLURAL  ),
    
    ESSA(   Genero.FEMININO,  Numero.SINGULAR),
    ESSAS(  Genero.FEMININO,  Numero.PLURAL  ),
    ESSE(   Genero.MASCULINO, Numero.SINGULAR),
    ESSES(  Genero.MASCULINO, Numero.PLURAL  ),
    
    AQUELA( Genero.FEMININO,  Numero.SINGULAR),
    AQUELAS(Genero.FEMININO,  Numero.PLURAL  ),
    AQUELE( Genero.MASCULINO, Numero.SINGULAR),
    AQUELES(Genero.MASCULINO, Numero.PLURAL  ),
    
    ISTO(   Genero.MASCULINO, Numero.INVARIAVEL),
    ISSO(   Genero.MASCULINO, Numero.INVARIAVEL),
    AQUILO( Genero.MASCULINO, Numero.INVARIAVEL),
    
    TAL( Genero.INVARIAVEL, Numero.SINGULAR ),
    TAIS(Genero.INVARIAVEL, Numero.PLURAL   ),
    
    A (Genero.FEMININO  , Numero.SINGULAR),
    AS(Genero.FEMININO  , Numero.PLURAL  ),
    O (Genero.MASCULINO , Numero.SINGULAR),
    OS(Genero.MASCULINO , Numero.PLURAL  );
    
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero;
    public final Numero número;
    
    Demonstrativo(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  enum Possessivo implements Pronome {
    // Um possuidor
    MINHA( Pessoa.PRIMEIRA, Genero.FEMININO , Numero.SINGULAR),
    MINHAS(Pessoa.PRIMEIRA, Genero.FEMININO , Numero.PLURAL  ),
    MEU(   Pessoa.PRIMEIRA, Genero.MASCULINO, Numero.SINGULAR),
    MEUS(  Pessoa.PRIMEIRA, Genero.MASCULINO, Numero.PLURAL  ),
    
    TUA(   Pessoa.SEGUNDA,  Genero.FEMININO , Numero.SINGULAR),
    TUAS(  Pessoa.SEGUNDA,  Genero.FEMININO , Numero.PLURAL  ),
    TEU(   Pessoa.SEGUNDA,  Genero.MASCULINO, Numero.SINGULAR),
    TEUS(  Pessoa.SEGUNDA,  Genero.MASCULINO, Numero.PLURAL  ),
    
    SUA(   Pessoa.TERCEIRA, Genero.FEMININO , Numero.SINGULAR),
    SUAS(  Pessoa.TERCEIRA, Genero.FEMININO , Numero.PLURAL  ),
    SEU(   Pessoa.TERCEIRA, Genero.MASCULINO, Numero.SINGULAR),
    SEUS(  Pessoa.TERCEIRA, Genero.MASCULINO, Numero.PLURAL  ),
    
    // Vários possuidores
    NOSSA( Pessoa.PRIMEIRA, Genero.FEMININO , Numero.SINGULAR),
    NOSSAS(Pessoa.PRIMEIRA, Genero.FEMININO , Numero.PLURAL  ),
    NOSSO( Pessoa.PRIMEIRA, Genero.MASCULINO, Numero.SINGULAR),
    NOSSOS(Pessoa.PRIMEIRA, Genero.MASCULINO, Numero.PLURAL  ),
    
    VOSSA( Pessoa.SEGUNDA,  Genero.FEMININO , Numero.SINGULAR),
    VOSSAS(Pessoa.SEGUNDA,  Genero.FEMININO , Numero.PLURAL  ),
    VOSSO( Pessoa.SEGUNDA,  Genero.MASCULINO, Numero.SINGULAR),
    VOSSOS(Pessoa.SEGUNDA,  Genero.MASCULINO, Numero.PLURAL  );
    
    public final Pessoa pessoa;
    public final Genero gênero;
    public final Numero número;
    
    Possessivo(
        Pessoa pessoa,
        Genero gênero,
        Numero número) {
      this.pessoa = pessoa;
      this.número = número;
      this.gênero = gênero;
    }
  
  }
  
  enum Indefinido implements Pronome {
    NENHUMA( Genero.FEMININO,  Numero.SINGULAR),
    NENHUMAS(Genero.FEMININO,  Numero.PLURAL  ),
    NENHUM(  Genero.MASCULINO, Numero.SINGULAR),
    NENHUNS( Genero.MASCULINO, Numero.PLURAL  ),
    
    TODA(  Genero.FEMININO,  Numero.SINGULAR),
    TODAS( Genero.FEMININO,  Numero.PLURAL  ),
    TODO(  Genero.MASCULINO, Numero.SINGULAR),
    TODOS( Genero.MASCULINO, Numero.PLURAL  ),
    
    ALGUMA(  Genero.FEMININO,  Numero.SINGULAR),
    ALGUMAS( Genero.FEMININO,  Numero.PLURAL  ),
    ALGUM(   Genero.MASCULINO, Numero.SINGULAR),
    ALGUNS(  Genero.MASCULINO, Numero.PLURAL  ),
    
    CERTA( Genero.FEMININO,  Numero.SINGULAR),
    CERTAS(Genero.FEMININO,  Numero.PLURAL  ),
    CERTO( Genero.MASCULINO, Numero.SINGULAR),
    CERTOS(Genero.MASCULINO, Numero.PLURAL  ),
    
    OUTRA( Genero.FEMININO,  Numero.SINGULAR),
    OUTRAS(Genero.FEMININO,  Numero.PLURAL  ),
    OUTRO( Genero.MASCULINO, Numero.SINGULAR),
    OUTROS(Genero.MASCULINO, Numero.PLURAL  ),
    
    MUITA( Genero.FEMININO,  Numero.SINGULAR),
    MUITAS(Genero.FEMININO,  Numero.PLURAL  ),
    MUITO( Genero.MASCULINO, Numero.SINGULAR),
    MUITOS(Genero.MASCULINO, Numero.PLURAL  ),
    
    POUCA( Genero.FEMININO,  Numero.SINGULAR),
    POUCAS(Genero.FEMININO,  Numero.PLURAL  ),
    POUCO( Genero.MASCULINO, Numero.SINGULAR),
    POUCOS(Genero.MASCULINO, Numero.PLURAL  ),
    
    // Vári()
    VARIA( Genero.FEMININO,  Numero.SINGULAR),
    VARIAS(Genero.FEMININO,  Numero.PLURAL  ),
    VARIO( Genero.MASCULINO, Numero.SINGULAR),
    VARIOS(Genero.MASCULINO, Numero.PLURAL  ),
    
    TANTA( Genero.FEMININO,  Numero.SINGULAR),
    TANTAS(Genero.FEMININO,  Numero.PLURAL  ),
    TANTO( Genero.MASCULINO, Numero.SINGULAR),
    TANTOS(Genero.MASCULINO, Numero.PLURAL  ),
    
    QUANTA( Genero.FEMININO,  Numero.SINGULAR),
    QUANTAS(Genero.FEMININO,  Numero.PLURAL  ),
    QUANTO( Genero.MASCULINO, Numero.SINGULAR),
    QUANTOS(Genero.MASCULINO, Numero.PLURAL  ),
    
    QUALQUER(   Genero.INVARIAVEL, Numero.SINGULAR),
    QUAISQUER(Genero.INVARIAVEL, Numero.PLURAL),
    
    ALGO(   Genero.INVARIAVEL, Numero.INVARIAVEL),
    ALGUÉM( Genero.INVARIAVEL, Numero.INVARIAVEL),
    NINGUÉM(Genero.INVARIAVEL, Numero.INVARIAVEL),
    TUDO(   Genero.INVARIAVEL, Numero.INVARIAVEL),
    OUTREM( Genero.INVARIAVEL, Numero.INVARIAVEL),
    NADA(   Genero.INVARIAVEL, Numero.INVARIAVEL),
    CADA(   Genero.INVARIAVEL, Numero.INVARIAVEL);
    
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero;
    public final Numero número;
    
    Indefinido(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  enum Relativo implements Pronome {
    QUE(  Numero.INVARIAVEL),
    QUEM( Numero.INVARIAVEL),
    QUAL( Numero.SINGULAR),
    QUAIS(Numero.PLURAL);
  
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero = Genero.INVARIAVEL;
    public final Numero número;
    
    Relativo(
        Numero número) {
      this.número = número;
    }
  
  }
  
  enum Interrogativo implements Pronome {
    QUE(   Numero.INVARIAVEL),
    QUÊ(   Numero.INVARIAVEL),
    QUEM(  Numero.INVARIAVEL),
    QUANTO(Numero.INVARIAVEL);
  
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero = Genero.INVARIAVEL;
    public final Numero número;
    
    Interrogativo(Numero número) {
      this.número = número;
    }
  
  }
  
}
