
package org.quipa.dialogo.gramatica;

import static org.quipa.dialogo.gramatica.Flexao.Pessoa;
import static org.quipa.dialogo.gramatica.Flexao.Genero;
import static org.quipa.dialogo.gramatica.Flexao.Numero;

interface Quantificador extends Palavra {
  
  enum Universal implements Quantificador {
    NENHUMA(  Genero.FEMININO,  Numero.SINGULAR),
    NENHUMAS( Genero.FEMININO,  Numero.PLURAL  ),
    NENHUM(   Genero.MASCULINO, Numero.SINGULAR),
    NENHUNS(  Genero.MASCULINO, Numero.PLURAL  ),
    
    TODA(     Genero.FEMININO,  Numero.SINGULAR),
    TODAS(    Genero.FEMININO,  Numero.PLURAL  ),
    TODO(     Genero.MASCULINO, Numero.SINGULAR),
    TODOS(    Genero.MASCULINO, Numero.PLURAL  ),
    
    AMBOS(    Genero.INVARIAVEL, Numero.PLURAL    ),
    CADA(     Genero.INVARIAVEL, Numero.INVARIAVEL),
    QUALQUER( Genero.INVARIAVEL, Numero.SINGULAR  ),
    QUAISQUER(Genero.INVARIAVEL, Numero.PLURAL    );
    
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero;
    public final Numero número;
  
    Universal(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  }
  
  enum Existencial implements Quantificador {
    ALGUMA( Genero.FEMININO,  Numero.SINGULAR),
    ALGUMAS(Genero.FEMININO,  Numero.PLURAL  ),
    ALGUM(  Genero.MASCULINO, Numero.SINGULAR),
    ALGUNS( Genero.MASCULINO, Numero.PLURAL  ),
    
    POUCA(  Genero.FEMININO,  Numero.SINGULAR),
    POUCAS( Genero.FEMININO,  Numero.PLURAL  ),
    POUCO(  Genero.MASCULINO, Numero.SINGULAR),
    POUCOS( Genero.MASCULINO, Numero.PLURAL  ),
    
    MUITA(  Genero.FEMININO,  Numero.SINGULAR),
    MUITAS( Genero.FEMININO,  Numero.PLURAL  ),
    MUITO(  Genero.MASCULINO, Numero.SINGULAR),
    MUITOS( Genero.MASCULINO, Numero.PLURAL  ),
    
    VÁRIA(  Genero.FEMININO,  Numero.SINGULAR),
    VÁRIAS( Genero.FEMININO,  Numero.PLURAL  ),
    VÁRIO(  Genero.MASCULINO, Numero.SINGULAR),
    VÁRIOS( Genero.MASCULINO, Numero.PLURAL  ),
    
    DIVERSA(  Genero.FEMININO,  Numero.SINGULAR),
    DIVERSAS( Genero.FEMININO,  Numero.PLURAL  ),
    DIVERSO(  Genero.MASCULINO, Numero.SINGULAR),
    DIVERSOS( Genero.MASCULINO, Numero.PLURAL  ),
    
    RARA( Genero.FEMININO,  Numero.SINGULAR),
    RARAS(Genero.FEMININO,  Numero.PLURAL  ),
    RARO( Genero.MASCULINO, Numero.SINGULAR),
    RAROS(Genero.MASCULINO, Numero.PLURAL  ),
    
    ALGO( Genero.INVARIAVEL, Numero.INVARIAVEL),
    ALGUÉM(Genero.INVARIAVEL, Numero.INVARIAVEL),
    
    BASTANTE( Genero.INVARIAVEL, Numero.SINGULAR),
    BASTANTES(Genero.INVARIAVEL, Numero.PLURAL),
    
    /*
    UMA(  Genero.FEMININO,  Numero.SINGULAR),
    UMAS( Genero.FEMININO,  Numero.PLURAL  ),
    UM(   Genero.MASCULINO, Numero.SINGULAR),
    UNS(  Genero.MASCULINO, Numero.PLURAL  );
    */
    ;
  
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero;
    public final Numero número;
    
    Existencial(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  interface Numeral extends Quantificador {}
  
  enum Cardinal implements Numeral {
    // UM(         Numero.SINGULAR),
    DOIS(       Numero.PLURAL),
    TRÊS(       Numero.PLURAL),
    QUATRO(     Numero.PLURAL),
    CINCO(      Numero.PLURAL),
    SEIS(       Numero.PLURAL),
    SETE(       Numero.PLURAL),
    OITO(       Numero.PLURAL),
    NOVE(       Numero.PLURAL),
    DEZ(        Numero.PLURAL),
    ONZE(       Numero.PLURAL),
    DOZE(       Numero.PLURAL),
    TREZE(      Numero.PLURAL),
    QUATORZE(   Numero.PLURAL),
    QUINZE(     Numero.PLURAL),
    DEZASSEIS(  Numero.PLURAL),
    DEZASSETE(  Numero.PLURAL),
    DEZOITO(    Numero.PLURAL),
    DEZANOVE(   Numero.PLURAL),
    VINTE(      Numero.PLURAL),
    TRINTA(     Numero.PLURAL),
    QUARENTA(   Numero.PLURAL),
    CINQUENTA(  Numero.PLURAL),
    SETENTA(    Numero.PLURAL),
    OITENTA(    Numero.PLURAL),
    NOVENTA(    Numero.PLURAL),
    CEM(        Numero.PLURAL),
    DUZENTOS(   Numero.PLURAL),
    TREZENTOS(  Numero.PLURAL),
    QUATROCENTOS(Numero.PLURAL),
    QUINHENTOS( Numero.PLURAL),
    SEISCENTOS( Numero.PLURAL),
    SETECENTOS( Numero.PLURAL),
    OITOCENTOS( Numero.PLURAL),
    NOVECENTOS( Numero.PLURAL),
    MIL(        Numero.PLURAL),
    MILHÃO(     Numero.PLURAL),
    
    ;
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero = Genero.INVARIAVEL;
    public final Numero número;
    
    Cardinal(
        Numero número) {
      this.número = número;
    }
  
  }
  
  enum Fracionario implements Numeral {
    MEIO(   Genero.MASCULINO, Numero.SINGULAR),
    MEIOS(  Genero.MASCULINO, Numero.PLURAL  ),
    METADE( Genero.FEMININO,  Numero.SINGULAR),
    METADES(Genero.FEMININO,  Numero.PLURAL  ),
    TERÇO(  Genero.MASCULINO, Numero.SINGULAR),
    TERÇOS( Genero.MASCULINO, Numero.PLURAL  ),
    QUARTO( Genero.MASCULINO, Numero.SINGULAR),
    QUARTOS(Genero.MASCULINO, Numero.PLURAL  ),
    QUINTO( Genero.MASCULINO, Numero.SINGULAR),
    QUINTOS(Genero.MASCULINO, Numero.PLURAL  ),
    SEXTO(  Genero.MASCULINO, Numero.SINGULAR),
    SEXTOS( Genero.MASCULINO, Numero.PLURAL  ),
    SÉTIMO( Genero.MASCULINO, Numero.SINGULAR),
    SÉTIMOS(Genero.MASCULINO, Numero.PLURAL  ),
    OITAVO( Genero.MASCULINO, Numero.SINGULAR),
    OITAVOS(Genero.MASCULINO, Numero.PLURAL  ),
    NONO(   Genero.MASCULINO, Numero.SINGULAR),
    NONOS(  Genero.MASCULINO, Numero.PLURAL  ),
    DÉCIMO( Genero.MASCULINO, Numero.SINGULAR),
    DÉCIMOS(Genero.MASCULINO, Numero.PLURAL  ),
    CENTÉSIMO(    Genero.MASCULINO, Numero.SINGULAR),
    CENTÉSIMOS(   Genero.MASCULINO, Numero.PLURAL  ),
    MILÉSIMO(     Genero.MASCULINO, Numero.SINGULAR),
    MILÉSIMOS(    Genero.MASCULINO, Numero.PLURAL  ),
    MILIONÉSIMO(  Genero.MASCULINO, Numero.SINGULAR),
    MILIONÉSIMOs( Genero.MASCULINO, Numero.PLURAL  );
    
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero;
    public final Numero número;
    
    Fracionario(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  enum Multiplicativo implements Numeral {
    DOBRO,
    DUPLO,  // DÚPLICE
    TRIPLO, // TRÍPLICE
    QUÁDRUPLO,
    QUÍNTUPLO,
    SÊXTUPLO,
    SÉPTUPLO,
    ÓCTUPLO,
    NÓNUPLO,
    DÉCUPLO;
    
    public final Pessoa pessoa = Pessoa.INVARIAVEL;
    public final Genero gênero = Genero.MASCULINO;
    public final Numero número = Numero.INVARIAVEL;
  
  }
  
  enum Interrogativo implements Quantificador {
    QUANTA( Genero.FEMININO,  Numero.SINGULAR ),
    QUANTAS(Genero.FEMININO,  Numero.PLURAL   ),
    QUANTO( Genero.MASCULINO, Numero.SINGULAR ),
    QUANTOS(Genero.MASCULINO, Numero.PLURAL   );
    
    public final Pessoa pessoa = Pessoa.INVARIAVEL;;
    public final Genero gênero;
    public final Numero número;
    
    Interrogativo(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
  enum Relativo implements Quantificador  {
    QUANTA( Genero.FEMININO,  Numero.SINGULAR ),
    QUANTAS(Genero.FEMININO,  Numero.PLURAL   ),
    QUANTO( Genero.MASCULINO, Numero.SINGULAR ),
    QUANTOS(Genero.MASCULINO, Numero.PLURAL   );
    
    public final Pessoa pessoa = Pessoa.INVARIAVEL;;
    public final Genero gênero;
    public final Numero número;
    
    Relativo(
        Genero gênero,
        Numero número) {
      this.gênero = gênero;
      this.número = número;
    }
  
  }
  
}
