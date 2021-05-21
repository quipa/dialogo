
// With Java 9 you can use Map.of() and Map.ofEntries()

package org.quipa.dialogo.gramatica;

import java.util.HashSet;
import java.util.HashMap;
import java.util.Set;
import java.util.Map;

import static org.quipa.dialogo.gramatica.Flexao.Pessoa;
import static org.quipa.dialogo.gramatica.Flexao.Genero;
import static org.quipa.dialogo.gramatica.Flexao.Numero;

class Lexico {

  public static final Map<String, Set<Palavra>> palavras;
  
  static {
    palavras = new HashMap<>();
    
    palavras.put("a"  , new HashSet<Palavra>());
    palavras.put("as" , new HashSet<Palavra>());
    palavras.put("o"  , new HashSet<Palavra>());
    palavras.put("os" , new HashSet<Palavra>());
    
    palavras.put("uma", new HashSet<Palavra>());
    palavras.put("uma", new HashSet<Palavra>());
    palavras.put("um" , new HashSet<Palavra>());
    palavras.put("uns", new HashSet<Palavra>());
    
    // DONE
    palavras.get("a"  ).add(Determinante.Artigo.A );
    palavras.get("as" ).add(Determinante.Artigo.AS);
    palavras.get("o"  ).add(Determinante.Artigo.O );
    palavras.get("os" ).add(Determinante.Artigo.OS);
    
    palavras.get("uma").add(Determinante.Artigo.UMA );
    palavras.get("uma").add(Determinante.Artigo.UMAS);
    palavras.get("um" ).add(Determinante.Artigo.UM  );
    palavras.get("uns").add(Determinante.Artigo.UNS );
    
    palavras.get("a"  ).add(Pronome.Pessoal.A );
    palavras.get("as" ).add(Pronome.Pessoal.AS);
    palavras.get("o"  ).add(Pronome.Pessoal.O );
    palavras.get("os" ).add(Pronome.Pessoal.OS);
    
    palavras.get("a"  ).add(Pronome.Demonstrativo.A );
    palavras.get("as" ).add(Pronome.Demonstrativo.AS);
    palavras.get("o"  ).add(Pronome.Demonstrativo.O );
    palavras.get("os" ).add(Pronome.Demonstrativo.OS);
    
    // pronomes pessoais DONE
    palavras.put("eu"  , new HashSet<Palavra>());
    palavras.put("tu"  , new HashSet<Palavra>());
    palavras.put("ela" , new HashSet<Palavra>());
    palavras.put("ele" , new HashSet<Palavra>());
    palavras.put("nós" , new HashSet<Palavra>());
    palavras.put("vós" , new HashSet<Palavra>());
    palavras.put("elas", new HashSet<Palavra>());
    palavras.put("eles", new HashSet<Palavra>());
    
    palavras.put("me"  , new HashSet<Palavra>());
    palavras.put("te"  , new HashSet<Palavra>());
    palavras.put("se"  , new HashSet<Palavra>());
    palavras.put("lhe" , new HashSet<Palavra>());
    palavras.put("nos" , new HashSet<Palavra>());
    palavras.put("vos" , new HashSet<Palavra>());
    palavras.put("lhes", new HashSet<Palavra>());
    
    palavras.put("mim" , new HashSet<Palavra>());
    palavras.put("ti"  , new HashSet<Palavra>());
    palavras.put("si"  , new HashSet<Palavra>());

    palavras.put("comigo"   , new HashSet<Palavra>());
    palavras.put("contigo"  , new HashSet<Palavra>());
    palavras.put("conosco"  , new HashSet<Palavra>());
    palavras.put("convosco" , new HashSet<Palavra>());
    
    palavras.get("eu"  ).add(Pronome.Pessoal.EU  );
    palavras.get("tu"  ).add(Pronome.Pessoal.TU  );
    palavras.get("ela" ).add(Pronome.Pessoal.ELA );
    palavras.get("ele" ).add(Pronome.Pessoal.ELE );
    palavras.get("nós" ).add(Pronome.Pessoal.NOS1);
    palavras.get("vós" ).add(Pronome.Pessoal.VOS2);
    palavras.get("elas").add(Pronome.Pessoal.ELAS);
    palavras.get("eles").add(Pronome.Pessoal.ELES);
    
    palavras.get("me"  ).add(Pronome.Pessoal.ME  );
    palavras.get("te"  ).add(Pronome.Pessoal.TE  );
    palavras.get("se"  ).add(Pronome.Pessoal.SE  );
    palavras.get("lhe" ).add(Pronome.Pessoal.LHE );
    palavras.get("nos" ).add(Pronome.Pessoal.NOS2);
    palavras.get("vos" ).add(Pronome.Pessoal.VOS2);
    palavras.get("lhes").add(Pronome.Pessoal.LHES);
    
    palavras.get("mim" ).add(Pronome.Pessoal.MIM );
    palavras.get("ti"  ).add(Pronome.Pessoal.TI  );
    palavras.get("si"  ).add(Pronome.Pessoal.SI1 );
    palavras.get("si"  ).add(Pronome.Pessoal.SI2 );
    
    palavras.get("comigo"  ).add(Pronome.Pessoal.COMIGO   );
    palavras.get("contigo" ).add(Pronome.Pessoal.CONTIGO  );
    palavras.get("conosco" ).add(Pronome.Pessoal.CONOSCO  );
    palavras.get("convosco").add(Pronome.Pessoal.CONVOSCO );
    
    // determinantes e pronomes demonstrativos e quantificadores existenciais
    palavras.put("esta"     , new HashSet<Palavra>());
    palavras.put("estas"    , new HashSet<Palavra>());
    palavras.put("este"     , new HashSet<Palavra>());
    palavras.put("estes"    , new HashSet<Palavra>());
    
    palavras.put("essa"     , new HashSet<Palavra>());
    palavras.put("essas"    , new HashSet<Palavra>());
    palavras.put("esse"     , new HashSet<Palavra>());
    palavras.put("esses"    , new HashSet<Palavra>());
    
    palavras.put("aquela"   , new HashSet<Palavra>());
    palavras.put("aquelas"  , new HashSet<Palavra>());
    palavras.put("aquele"   , new HashSet<Palavra>());
    palavras.put("aqueles"  , new HashSet<Palavra>());
    
    palavras.put("tal"      , new HashSet<Palavra>());
    palavras.put("tais"     , new HashSet<Palavra>());
    
    palavras.get("esta"   ).add(Determinante.Demonstrativo.ESTA);
    palavras.get("estas"  ).add(Determinante.Demonstrativo.ESTAS);
    palavras.get("este"   ).add(Determinante.Demonstrativo.ESTE);
    palavras.get("estes"  ).add(Determinante.Demonstrativo.ESTES);
    
    palavras.get("essa"   ).add(Determinante.Demonstrativo.ESSA);
    palavras.get("essas"  ).add(Determinante.Demonstrativo.ESSAS);
    palavras.get("esse"   ).add(Determinante.Demonstrativo.ESSE);
    palavras.get("esses"  ).add(Determinante.Demonstrativo.ESSES);
    
    palavras.get("aquela" ).add(Determinante.Demonstrativo.AQUELA);
    palavras.get("aquelas").add(Determinante.Demonstrativo.AQUELAS);
    palavras.get("aquele" ).add(Determinante.Demonstrativo.AQUELE);
    palavras.get("aqueles").add(Determinante.Demonstrativo.AQUELES);
    
    palavras.get("tal"    ).add(Determinante.Demonstrativo.TAL);
    palavras.get("tais"   ).add(Determinante.Demonstrativo.TAIS);
    
    // pronome demonstrativos
    palavras.put("isto"     , new HashSet<Palavra>());
    palavras.put("isso"     , new HashSet<Palavra>());
    palavras.put("aquilo"   , new HashSet<Palavra>());
    
    // determinantes e pronomes possessivos
    palavras.put("minha"    , new HashSet<Palavra>());
    palavras.put("minhas"   , new HashSet<Palavra>());
    palavras.put("meu"      , new HashSet<Palavra>());
    palavras.put("meus"     , new HashSet<Palavra>());
    
    palavras.put("tua"      , new HashSet<Palavra>());
    palavras.put("tuas"     , new HashSet<Palavra>());
    palavras.put("teu"      , new HashSet<Palavra>());
    palavras.put("teus"     , new HashSet<Palavra>());
    
    palavras.put("sua"      , new HashSet<Palavra>());
    palavras.put("suas"     , new HashSet<Palavra>());
    palavras.put("seu"      , new HashSet<Palavra>());
    palavras.put("seus"     , new HashSet<Palavra>());
    
    palavras.put("nossa"    , new HashSet<Palavra>());
    palavras.put("nossas"   , new HashSet<Palavra>());
    palavras.put("nosso"    , new HashSet<Palavra>());
    palavras.put("nossos"   , new HashSet<Palavra>());
    
    palavras.put("vossa"    , new HashSet<Palavra>());
    palavras.put("vossas"   , new HashSet<Palavra>());
    palavras.put("vosso"    , new HashSet<Palavra>());
    palavras.put("vossos"   , new HashSet<Palavra>());
    
    // quantificador universal, pronome indefinido
    
    palavras.put("nenhuma"  , new HashSet<Palavra>());
    palavras.put("nenhumas" , new HashSet<Palavra>());
    palavras.put("nenhum"   , new HashSet<Palavra>());
    palavras.put("nenhuns"  , new HashSet<Palavra>());

    palavras.put("toda"     , new HashSet<Palavra>());
    palavras.put("todas"    , new HashSet<Palavra>());
    palavras.put("todo"     , new HashSet<Palavra>());
    palavras.put("todos"    , new HashSet<Palavra>());
    
    palavras.put("qualquer" , new HashSet<Palavra>());
    palavras.put("quaisquer", new HashSet<Palavra>());
    
    // quantificador universal
    palavras.put("ambos"    , new HashSet<Palavra>());
    palavras.put("cada"     , new HashSet<Palavra>());
    
    // pronome indefinido
    /*
    ALGUMA(
    ALGUMAS    
    ALGUM(     
    ALGUNS(    
    
    MUITA( 
    MUITAS(
    MUITO( 
    MUITOS(
    
    POUCA( 
    POUCAS(
    POUCO( 
    POUCOS(
    
    VÁRIA( 
    VÁRIAS(
    VÁRIO( 
    VÁRIOS(
    
    TANTA( 
    TANTAS(
    TANTO( 
    TANTOS(
    */
    
    // determinantes, pronomes e quantificadores indefinidos
    palavras.put("certa"    , new HashSet<Palavra>());
    palavras.put("certas"   , new HashSet<Palavra>());
    palavras.put("certo"    , new HashSet<Palavra>());
    palavras.put("certos"   , new HashSet<Palavra>());
    
    palavras.put("outra"    , new HashSet<Palavra>());
    palavras.put("outras"   , new HashSet<Palavra>());
    palavras.put("outro"    , new HashSet<Palavra>());
    palavras.put("outros"   , new HashSet<Palavra>());
    
    // Quantificador existencial
    palavras.put("alguma"   , new HashSet<Palavra>());
    palavras.put("algumas"  , new HashSet<Palavra>());
    palavras.put("algum"    , new HashSet<Palavra>());
    palavras.put("alguns"   , new HashSet<Palavra>());
    
    palavras.put("pouca"    , new HashSet<Palavra>());
    palavras.put("poucas"   , new HashSet<Palavra>());
    palavras.put("pouco"    , new HashSet<Palavra>());
    palavras.put("poucos"   , new HashSet<Palavra>());
    
    palavras.put("muita"    , new HashSet<Palavra>());
    palavras.put("muitas"   , new HashSet<Palavra>());
    palavras.put("muito"    , new HashSet<Palavra>());
    palavras.put("muitos"   , new HashSet<Palavra>());
    
    palavras.put("vária"    , new HashSet<Palavra>());
    palavras.put("várias"   , new HashSet<Palavra>());
    palavras.put("vário"    , new HashSet<Palavra>());
    palavras.put("vários"   , new HashSet<Palavra>());
    
    palavras.put("diversa"  , new HashSet<Palavra>());
    palavras.put("diversas" , new HashSet<Palavra>());
    palavras.put("diverso"  , new HashSet<Palavra>());
    palavras.put("diversos" , new HashSet<Palavra>());
    
    palavras.put("rara"     , new HashSet<Palavra>());
    palavras.put("raras"    , new HashSet<Palavra>());
    palavras.put("raro"     , new HashSet<Palavra>());
    palavras.put("raros"    , new HashSet<Palavra>());
    
    palavras.put("algo"     , new HashSet<Palavra>());
    palavras.put("alguém"   , new HashSet<Palavra>());

    palavras.put("bastante" , new HashSet<Palavra>());
    palavras.put("bastantes", new HashSet<Palavra>());
    
    // determinante, pronomes e quantificadores relativos e interrogativos
    
    palavras.put("cuja"     , new HashSet<Palavra>());
    palavras.put("cujas"    , new HashSet<Palavra>());
    palavras.put("cujo"     , new HashSet<Palavra>());
    palavras.put("cujos"    , new HashSet<Palavra>());
    
    // quantificador relativo e interrogativo e pronomes indefinidos
    palavras.put("quanta"   , new HashSet<Palavra>());
    palavras.put("quantas"  , new HashSet<Palavra>());
    palavras.put("quanto"   , new HashSet<Palavra>());
    palavras.put("quantos"  , new HashSet<Palavra>());
    
    palavras.put("que"      , new HashSet<Palavra>());
    palavras.put("qual"     , new HashSet<Palavra>());
    palavras.put("quais"    , new HashSet<Palavra>());
    
    
    palavras.get("esta"   ).add(Determinante.Demonstrativo.ESTA   );
    palavras.get("estas"  ).add(Determinante.Demonstrativo.ESTAS  );
    palavras.get("este"   ).add(Determinante.Demonstrativo.ESTE   );
    palavras.get("estes"  ).add(Determinante.Demonstrativo.ESTES  );
    palavras.get("essa"   ).add(Determinante.Demonstrativo.ESSA   );
    palavras.get("essas"  ).add(Determinante.Demonstrativo.ESSAS  );
    palavras.get("esse"   ).add(Determinante.Demonstrativo.ESSE   );
    palavras.get("esses"  ).add(Determinante.Demonstrativo.ESSES  );
    palavras.get("aquela" ).add(Determinante.Demonstrativo.AQUELA );
    palavras.get("aquelas").add(Determinante.Demonstrativo.AQUELAS);
    palavras.get("aquele" ).add(Determinante.Demonstrativo.AQUELE );
    palavras.get("aqueles").add(Determinante.Demonstrativo.AQUELES);
    
    // Preposições essenciais DONE
    palavras.put("ante"   , new HashSet<Palavra>());
    palavras.put("com"    , new HashSet<Palavra>());
    palavras.put("de"     , new HashSet<Palavra>());
    palavras.put("desde"  , new HashSet<Palavra>());
    palavras.put("em"     , new HashSet<Palavra>());
    palavras.put("para"   , new HashSet<Palavra>());
    palavras.put("perante", new HashSet<Palavra>());
    palavras.put("sem"    , new HashSet<Palavra>());
    palavras.put("sob"    , new HashSet<Palavra>());
    palavras.put("trás"   , new HashSet<Palavra>());
    
    palavras.get("ante"   ).add(Preposicao.ANTE   );
    palavras.get("com"    ).add(Preposicao.COM    );
    palavras.get("de"     ).add(Preposicao.DE     );
    palavras.get("desde"  ).add(Preposicao.DESDE  );
    palavras.get("em"     ).add(Preposicao.EM     );
    palavras.get("para"   ).add(Preposicao.PARA   );
    palavras.get("perante").add(Preposicao.PERANTE);
    palavras.get("sem"    ).add(Preposicao.SEM    );
    palavras.get("sob"    ).add(Preposicao.SOB    );
    palavras.get("trás"   ).add(Preposicao.TRAS   );
    
    // Preposições acidental
    palavras.get("a").add(Preposicao.A);
    
    palavras.put("após"    ,  new HashSet<>());
    palavras.put("até"     ,  new HashSet<>());
    palavras.put("como"    ,  new HashSet<>());
    palavras.put("conforme",  new HashSet<>());
    palavras.put("contra"  ,  new HashSet<>());
    palavras.put("durante" ,  new HashSet<>());
    palavras.put("exceto"  ,  new HashSet<>());
    palavras.put("entre"   ,  new HashSet<>());
    palavras.put("fora"    ,  new HashSet<>());
    palavras.put("mais"    ,  new HashSet<>());
    palavras.put("menos"   ,  new HashSet<>());
    palavras.put("por"     ,  new HashSet<>());
    palavras.put("que",       new HashSet<>());
    palavras.put("salvo"   ,  new HashSet<>());
    palavras.put("senao"   ,  new HashSet<>());
    palavras.put("sobre"   ,  new HashSet<>());
    palavras.put("mediante",  new HashSet<>());
    
    palavras.get("após"    ).add(Preposicao.APOS     );
    palavras.get("até"     ).add(Preposicao.ATE      );
    // palavras.get("como"    ).add(Preposicao.COMO     );
    palavras.get("conforme").add(Preposicao.CONFORME );
    palavras.get("contra"  ).add(Preposicao.CONTRA   );
    palavras.get("durante" ).add(Preposicao.DURANTE  );
    palavras.get("exceto"  ).add(Preposicao.EXCETO   );
    palavras.get("entre"   ).add(Preposicao.ENTRE    );
    palavras.get("fora"    ).add(Preposicao.FORA     );
    palavras.get("mais"    ).add(Preposicao.MAIS     );
    palavras.get("menos"   ).add(Preposicao.MENOS    );
    palavras.get("por"     ).add(Preposicao.POR      );
    palavras.get("que"     ).add(Preposicao.QUE      );
    palavras.get("salvo"   ).add(Preposicao.SALVO    );
    palavras.get("senao"   ).add(Preposicao.SENAO    );
    palavras.get("sobre"   ).add(Preposicao.SOBRE    );
    palavras.get("mediante").add(Preposicao.MEDIANTE );
    
    // Conjunções
    palavras.get("conforme" ).add(Conjuncao.Subordinativa.CONFORME);
    
    // Nomes?
    // Adjetivos
    palavras.get("conforme" ).add(new Adjetivo(Numero.SINGULAR));
    palavras.get("conformes").add(new Adjetivo(Numero.PLURAL));
    // Advérbios
    palavras.get("após"    ).add(new Adverbio());
    palavras.get("até"     ).add(new Adverbio());
    
    
  }
  
  public static Set<Palavra> pesquisa(String palavra) {
    return palavras.get(palavra);
  }
  
}
