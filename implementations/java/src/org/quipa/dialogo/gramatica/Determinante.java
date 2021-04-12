
package org.quipa.dialogo.gramatica;

import static org.quipa.dialogo.gramatica.Flexao.Pessoa;
import static org.quipa.dialogo.gramatica.Flexao.Genero;
import static org.quipa.dialogo.gramatica.Flexao.Numero;


interface Determinante extends Palavra {

  enum Artigo implements Determinante {
    A( Genero.FEMININO,   Numero.SINGULAR),
    AS(Genero.FEMININO,   Numero.PLURAL  ),
    O( Genero.MASCULINO,  Numero.SINGULAR),
    OS(Genero.MASCULINO,  Numero.PLURAL  ),
    
    UMA(  Genero.FEMININO,  Numero.SINGULAR),
    UMAS( Genero.FEMININO,  Numero.PLURAL  ),
    UM(   Genero.MASCULINO, Numero.SINGULAR),
    UNS(  Genero.MASCULINO, Numero.PLURAL  );
  
    public final Genero gênero;
    public final Numero número;
    
    Artigo(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  enum Demonstrativo implements Determinante {
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
    TAL(    Genero.INVARIAVEL,Numero.SINGULAR),
    TAIS(   Genero.INVARIAVEL,Numero.PLURAL  );
    
    public final Genero gênero;
    public final Numero número;
    
    Demonstrativo(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  enum Possessivo implements Determinante {
    
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
  
  enum Indefinido implements Determinante {
    CERTA(   Genero.FEMININO,  Numero.SINGULAR),
    CERTAS(  Genero.FEMININO,  Numero.PLURAL  ),
    CERTO(   Genero.MASCULINO, Numero.SINGULAR),
    CERTOS(  Genero.MASCULINO, Numero.PLURAL  ),
    
    OUTRA(   Genero.FEMININO,  Numero.SINGULAR),
    OUTRAS(  Genero.FEMININO,  Numero.PLURAL  ),
    OUTRO(   Genero.MASCULINO, Numero.SINGULAR),
    OUTROS(  Genero.MASCULINO, Numero.PLURAL  );
    
    public final Genero gênero;
    public final Numero número;
    
    Indefinido(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  enum Relativo implements Determinante {
    CUJA( Genero.FEMININO,   Numero.SINGULAR),
    CUJAS(Genero.FEMININO,   Numero.PLURAL  ),
    CUJO( Genero.MASCULINO,  Numero.SINGULAR),
    CUJOS(Genero.MASCULINO,  Numero.PLURAL  );
  
    public final Genero gênero;
    public final Numero número;
    
    Relativo(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
    
  enum Interrogativo implements Determinante {
    QUE(  Numero.INVARIAVEL),
    QUAL( Numero.SINGULAR),
    QUAIS(Numero.PLURAL);
  
    public final Numero número;
    
    Interrogativo(Numero número) {
      this.número = número;
    }
  
  }
  
}
