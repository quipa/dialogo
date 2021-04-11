# Dialogo
Uma linguagem para diálogo entre humanos e computadores.

## Objetivo
Criar e usar sistemas interativos de informação de modo simples e fléxivel.

## Requisitos
* **Humanos**:
  * DEVE ser fácil de ler, escrever e compreender para pessoas com educação de ensino médio Brasileiro;
  * DEVE ser fácil de ler e compreender para pessoas com educação básica e auxílio de terceiros.
  * DEVE ser fácil de aprender e ensinar num curto espaço de tempo;
  * DEVE ser baseada em Português e ter uma sintaxe e semântica quase natural;
  * DEVE permitir criar, pesquisar, atualizar e apagar informações de modo simples e fléxivel;
  * DEVE permitir armazenar informações num formato textual legível para humanos;
  * DEVE ser fácil de instalar e configurar;
* **Tecnológicos**
  * DEVE ser bem definida e não-ambígua em termos computacionais;
  * DEVE ter poucas dependências obrigatórias;
  * NÃO DEVE deve depender de conexão de Internet para instalar, configurar e utilizar.
  * DEVE suportar sistemas operativos *desktop* (Windows, GNU/Linux, Windows)
  * PODE suportar sistemas operativos *mobile* e plataformas *web*;
  * PODE criar interfaces gráficas para sistemas de informação.
  * PODE integrar sistemas de informação externos (através de API, bindings e protocolos);

## Histórico
Esta linguagem foi inspirada por experiências de ensino/aprendizado do [Projeto Quipá](https://www.facebook.com/projetoquipa/) durante a sua campanha *Ação no Sertão* de 2019 no Território Serra da Capivara, Piauí, Brasil. Durante esta campanha foram organizados cursos em colaboração com a [Cáritas Diocesana de São Raimundo Nonato](https://www.facebook.com/CaritasSRN/) junto com comunidades rurais, técnicos e profissionais de extensão e estudantes de ensino técnico da Escola Família Agrícola da Serra da Capivara.

A linguagem está sendo concebida por Maxim Simões de Abreu Jaffe no âmbito do mestrado em Gestão dos Recursos Naturais da [Universidade de Trás-os-Montes e Alto Douro, Portugal](http://www.utad.pt/). Será utilizada futuramente para extensão rural e agroecológica em comunidades rurais e urbanas no Território Serra da Capivara, Piauí, Brasil.

## Proposta

**em construção**

A linguagem tem uma sintaxe quase natural, com documentos compostos por frases que podem ser declarações, interrogações ou exclamações, cada uma permitindo um certo tipo de interação com o sistema de informação.

Cada frase é constituída por termos (palavras, símbolos, números, listas, texto literal, etc.).

```dialogo
# comentários começam e terminam com um jogo-da-velha/cardinal #

A Maria é uma agricultora.  # uma declaração altera informação      #
O José é um apicultor?      # uma interrogação pesquisa informação  #
O Pedro é um criador!       # uma exclamação verifica informação    #
```

A pontuação da linguagem é [fixa](#gramatica). Mas a linguagem tem *construções* de frase dinâmicas que podem ser definidas pelo usuário.

Cada construção tem um procedimento associado, dependendo do tipo de frase. Por exemplo, a primeira frase acima tem um procedimento que declara que a entidade `Maria` é do tipo `agricultora`.

Cada construção é composta por um identificador principal, padrões e diversos identificadores chave. Por exemplo, as frases acima seguem a construção `(uma entidade) é (um tipo)`, composto do identificador principal `é` um padrão de entidade e um padrão de tipo.

Uma frase é construída combinando termos em construções. A seguinte frase é composta por diversas construções:

```dialogo
[A Ana] é [uma apicultora].

# construções
A (uma palavra)   -> uma entidade
uma (uma palavra) -> um tipo
(uma entidade) é (um tipo)
#
```

Diversas construções podem ter o mesmo identificador principal, o que permite que o mesmo identificador tenha diversos procedimentos (diversos significados).

```dialogo
# (uma entidade) é (um tipo)?
  pesquisa se a entidade é de um certo tipo. #

A Maria é uma agricultora?

# (uma entidade) é (uma entidade).
  declara um sinónimo para a entidade. #

A Ana é a vendedora.

# (um tipo) é (um tipo)!
Uma agricultora é uma pessoa!  
```

A linguagem além de ter diversas construções padrão do tipo sujeito-verbo-objeto, tem também :

Frases são compostos por termos, incluindo palavras, símbolos, números e texto literal.


Símbolos geralmente são operadores de construções, por exemplo construções aritméticas. linguagem tem diversas construções padrão para operações Outro tipo de construção padrão são :

```
1 + 2. # adição         : (um número) + (um número)
3 + 4  # subtração      : (um número) +
3 * 4. # multiplicação  : (um número) * (um número)
5 / 6. # divisão        : (um número) / (um número)


As construções tem uma dada precedência:

As frases podem ser agrupadas em diversos tipos de grupos, que modificam como as frases são lidas (avaliadas).

```
O custo é 

Frases

As frases são compostos com base em con

A sintaxe será predominantemente dinâmica, podendo ser redefinada em tempo real. A pontuação da linguagem tem regras fixas que alteram como a linguagem é lida (avaliada). As frases são declarações, interrogações, exclamações.

### Exemplos

**NOTA: Em construção**

### Paradigmas

A linguagem suportará os seguintes paradigmas:
* Imperativo
* Orientado à objetos
  * Herança múltipla  (multiple inheritance)
  * Despacho múltiplo (multiple dispatch)
* Funcional
  * Funções de primeira-classe (first-class functions)
* Lógico
  * Procura encapsulada (encapsulated search)

### Notas de *Design*

**NOTA: Em construção**

## Inspiração
A linguagem é filosoficamente inspirada pela linguagem [Logo](#logo) (Dia*Logo*) concebida por [Seymour Papert](http://pt.wikipedia.org/wiki/Seymour_Papert), [Wally Feurzeig](https://en.wikipedia.org/wiki/Wally_Feurzeig), [Cynthia Solomon](https://en.wikipedia.org/wiki/Cynthia_Solomon) e a linguagem [Smalltalk](#smalltalk) (literalmente significa conversa fiada) concebida por [Alan Kay](http://pt.wikipedia.org/wiki/Alan_Kay), [Dan Ingalls](https://en.wikipedia.org/wiki/Dan_Ingalls) e [Adele Goldberg](https://en.wikipedia.org/wiki/Adele_Goldberg_(computer_scientist)), ambas baseadas na filosofia do construcionismo.

Ela é baseada em conceitos de linguística cognitiva:
* [Construções](http://en.wikipedia.org/wiki/Construction_grammar), frases incompletas com padrões (*slots*) que podem ser preenchidos com palavras ou outras construções.
* [Gramática categorial combinatória](https://pt.wikipedia.org/wiki/Gramática_categorial_combinatória) que associa a cada palavra um combinador que permite construir frases.

Outras linguagens de programação que influenciam a proposta:
* <a name="logo"></a>[Logo](http://pt.wikipedia.org/wiki/Logo)
* <a name="smalltalk"></a>[Smalltalk](http://pt.wikipedia.org/wiki/Smalltalk)
* [Lisp](http://en.wikipedia.org/wiki/Lisp_(programming_language))/[Scheme](http://en.wikipedia.org/wiki/Scheme_(programming_language))
* [Prolog](http://en.wikipedia.org/wiki/Prolog)
* [Inform 7](http://inform7.com/)
* [Attempto Controlled English](http://attempto.ifi.uzh.ch/site/)
* [Rebol](http://www.rebol.com/)
* [HyperTalk](http://en.wikipedia.org/wiki/HyperTalk)
* [Dylan](http://en.wikipedia.org/wiki/Dylan_(programming_language))
* [Tcl](http://www.tcl.tk/)
* <a name="cgol"></a>[CGOL](http://en.wikipedia.org/wiki/CGOL)
* [Raku](https://www.raku.org/)
* [Kernel](https://web.cs.wpi.edu/~jshutt/kernel.html)
* [Go!](https://en.wikipedia.org/wiki/Go!_(programming_language)) (não confundir com [Go](golang.org/))

## Implementação
Atualmente o projeto está a considerar utilizar a plataforma Java por os seguintes motivos:
* Portabilidade: a máquina virtual (JVM) e bibliotecas Java (APIs) permitem desenvolver software multiplataforma com poucas dependências.
* Flexibilidade: plataforma pode ser programa através de diversas linguagens (Java, Groovy, Kotlin, Scale, etc.).

A primeira implementação será um interpretador composto das seguintes fases de análise:

* Morfológica : identifica os[morfemas](#gmorfologica);
* Léxica      : identifica os [lexemas](#glexica);
* Sintática   : identifica as estruturas sintáticas ([sintagmas](#gsintatica));
* Semântica   : avalia o significado (sememas) associados a cada estrutura sintática.

As fases morfológica, léxica e sintática definem a gramática estática da linguagem, enquanto que a fase semântica definem a gramática dinâmica (construções e formatos).

A análise semântica será baseada no algoritmo *Top Down Operator Precedence* (TDOP) associando ao identificador principal de cada construção e a cada formato uma precedência. Este algoritmo foi desenvolvido por Vaughan Pratt nos anos 70 e utilizado para implementar a linguagem de programação [CGOL](#cgol).

Teoricamente o interpretador poderia ser implementado por completo com este algoritmo, mas a sepração por fases facilitar a deteção de erros e desenvolvimento modular do interpretador.

## <a name="gramatica"></a>Gramática estática

Segue a gramática estática da linguagem em formato [EBNF](https://pt.wikipedia.org/wiki/Formalismo_de_Backus-Naur_Estendido). Ela está divida em três sub-gramáticas e um léxico.

As sub-gramáticas devem ser interpretada como gramáticas [GASE](https://pt.wikipedia.org/wiki/Gramática_de_análise_sintática_de_expressão) (*[PEG](https://en.wikipedia.org/wiki/Parsing_expression_grammar)*), com alternativas `|` selecionadas da esquerda para a direita. 

O léxico deve ser interpretado como uma gramática [GLC](https://pt.wikipedia.org/wiki/Gramática_livre_de_contexto) (CFG), na qual cada palavra é associada com todos os significados possíveis ().

**NOTA: carateres latinos não são utilizados nos não-terminais da gramática porque o realce de sintaxe do Github não os reconhece.**

### <a name="gsintatica"></a>Sub-gramática sintática

```EBNF

documento       = paragrafo , [ espacos ] ;
paragrafo       = frase , { espacos , frase } ;

frase           = declaracao | interrogacao | exclamacao ;
declaracao      = periodo , '.' ;
interrogacao    = periodo , '?' ;
exclamacao      = periodo , '!' ;

periodo         = procedimento | macro | oracao ;

procedimento    = funcao | comando | regra | tipo ;
funcao          = 'função'  , [ oracao ] , bloco ;
comando         = 'comando' , [ oracao ] , bloco ;
regra           = 'regra'   , oracao , bloco ;
tipo            = 'tipo' , [ identificador ] , bloco ;

macro           = 'macro ' , procedimento ;

oracao          = [ espacos ] , termo , { espacos , termo } ;

termo           = item | grupo | lista ;

item            = literal | variavel chave | variavel | chave | identificador
                | comentario | misto ;

literal         = nulo | booleano | numero | texto ;

variavel chave  = ':' , identificador - reservado , ':'
                | ':' , grupo , variavel chave ;
variavel        = ':' , identificador - reservado
                | ':' , grupo , variavel ;

grupo           = expressao | bloco | padrao ;
expressao       = '[' , ( periodo | paragrafo ) , [ espacos ] , ']' ;
bloco           = '{' , ( periodo | paragrafo ) , [ espacos ] , '}' ;
padrao          = '(' , periodo , [ espacos ] , ')' l

lista           = ( item - chave | grupo )
                , ( ';' , espacos , ( item - chave | grupo ) )
                , { ';' , espacos , ( item - chave | grupo } ;
```

### <a name="glexica"></a>Sub-gramática léxica

```EBNF
lexema        = espacos | nulo | booleano | numero | texto | identificador
              | operador | reservado | comentario | misto ; 

espacos       = ESPACO , { ESPACO } ;

nulo          = 'nulo' ;

booleano      = 'verdadeiro' | 'falso' ;

numero        = real | fracional | inteiro ;
real          = ('-' | '+') , NUMERO , ',' , NUMERO ;
racional      = ('-' | '+') , NUMERO , '/' , NUMERO ;
inteiro       = decimal | binario | octal | hexadecimal ;
decimal       = ('-' | '+') , NUMERO ;
binario       = '0b' , NUMERO ;
octal         = '0o' , NUMERO ;
hexadecimal   = '0x' , NUMERO ;

texto         = TEXTO ;

chave         = identificador , ':' ;

identificador = reservado | operador | PALAVRA | COMPOSTO
              | identificador , { ':' , misto | LITERAL | identificador } ;

operador      = SIMBOLO , { SIMBOLO } ;

reservado     = 'macro' | 'função' | 'comando' | 'regra' | 'tipo' | 'nulo'
              | 'verdadeiro' | 'falso' | lexico ;

comentario    = COMENTARIO ;

misto         = CARATERE , { CARATERE | SINAL  - ':' } , CARATERE ;
```

### <a name="gmorfologica"></a>Sub-gramática morfológica

```EBNF
MORFEMA       = LITERAL | PALAVRA | COMPOSTO | COMENTARIO

LITERAL       = NUMERO | TEXTO ;

NUMERO        = DIGITO { DIGITO } ;

TEXTO         = "'" , { CORINGA - "'" | "\'" } , '"'
              | '"' , { CORINGA - '"' | '\"' } , '"'
              | '«' , { CORINGA - '»' | '\»' } , '»' ;

PALAVRA       = LETRA , { LETRA } ;
COMPOSTO      = '`' , CORINGA { CORINGA - '`' | '\`' } , '`' ;

COMENTARIO    = '#' , { '#' } , ESPACO , { (CORINGA - '#' | '\#') , ESPACO }
              , '#' , { '#' } ;

CORINGA   = ESPACO | CARATERE | SINAL ;

ESPACO    = ' ' | '\n' | '\t' ;

CARATERE  = LETRA | DIGITO | SIMBOLO ;

LETRA     = 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k'
          | 'l' | 'm' | 'n' | 'o' | 'p' | 'q' | 'r' | 's' | 't' | 'u' | 'v'
          | 'w' | 'x' | 'y' | 'z' |
          | 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G' | 'H' | 'I' | 'J' | 'K'
          | 'L' | 'M' | 'N' | 'O' | 'P' | 'Q' | 'R' | 'S' | 'T' | 'U' | 'V'
          | 'W' | 'X' | 'Y' | 'Z'
          | 'ç' | 'Ç'
          | 'ã' | 'õ'
          | 'á' | 'é' | 'í' | 'ó' | 'ú'
          | 'à' | 'è' | 'ì' | 'ò' | 'ù'
          | 'â' | 'ê' | 'ô'
          | 'Ã' | 'Õ'
          | 'Á' | 'É' | 'Í' | 'Ó' | 'Ú'
          | 'À' | 'È' | 'Ì' | 'Ò' | 'Ù'
          | 'Â' | 'Ê' | 'Ô' ;
DIGITO    = '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9' ;
SIMBOLO   = '+' | '-' | '*' | '/' | '=' | '<' | '>' | '%' | '|' | '&'
          | '$' | '@' | '\' | '_' | '~' | '^' ;

SINAL       = PONTO | DELIMITADOR ;
PONTO       = '.' | '?' | '!' | ':' | ';' | ',' ;
DELIMITADOR = '[' | ']' | '{' | '}' | '(' | ')'
            | '`' | "'" | '"' | '«' | '»' | '#' ;
```

### <a name="lexico"></a>Léxico de palavras reservadas

As seguintes palavras são reservadas e não podem ser redefinidas, mas podem ser utilizadas como identificadores, chaves (`de:`) ou palavras compostas (`como`, 1a pess. do sing. pres. indi. de *comer*).

adj.    : adjetivo
adv.    : advérbio
art.    : artigo
conj.   : conjunção
det.    : determinante
prep.   : preposição
pron.   : pronome
quant.  : quantificador
v.      : verbo
n. m.   : nome masculino
n. f.   : nome feminindo

Palavras ambíguas tem várias construções associadas, cada associada a um significado.

Observações:
* Lista tenta ser exaustiva para palavras de classe fechada (determinantes, pronomes, quantificador, preposições, conjunções, contrações), e indicativa para palavras de classe aberta (adjetivos e advérbios).
* Consideram-se somente preposições essenciais aquelas que não tenham mais nenhum significado por si só (excluindo algumas preposições geralmente consideradas essenciais).
* Palavras seguem a ortografia brasileira (pt-BR).
* As palavras estão em caixa baixa, mas podem também ser escritas em caixa alta. 
* São excluídas:
  * Formas atónicas dos pronomes pessoais
  * Conjunções correlativas
  * Lista não inclui locuções adverbiais, prepositivas, conjuncionais (por agora)

**NOTA: em construção**

Quanto à categoria da palavra:

```EBNF

lexico    = classe aberta | classe fechada ;

classe aberta    = verbo | adjetivo | adverbio ;

verbo     = ser | estar | ter ;

ser       = 'é' | 'são'

estar     = 'está'  | 'estão' 

ter       = 'tem' ;

adjetivo  = adjetivo comparativo | adjetivo superlativo

adjetivo normal       = 'boa' | 'boas'  | 'bom' | 'bons'
                      | 'má'  | 'más'   | 'mau' | 'maus'
                      | 'grande'  | 'grandes'
                      | 'pequena' | 'pequenas'  | 'pequeno' | 'pequenos' ;

adjetivo comparativo  = 'melhor'  | 'melhores'
                      | 'pior'    | 'piores'
                      | 'menor'   | 'menores'
                      | 'maior'   | 'maiores' ;

adjetivo superlativo  = 'ótima'   | 'ótimas'  | 'ótimo'   | 'ótimos'
                      | 'péssima' | 'péssimas'| 'péssimo' | 'péssimos'
                      | 'máxima'  | 'máximas' | 'máximo'  | 'máximos'
                      | 'mínima'  | 'mínimas' | 'mínimo'  | 'mínimos' ;

adverbio  = adverbio de predicado
          | adverbio de afirmacao
          | adverbio de negacao
          | adverbio de interogacao
          | adverbio de quantidade
          | adverbio de intensidade
          | adverbio de duvida
          | adverbio de demonstracao
          | adverbio de inclusao e exclusao 
          | 'que' | 'mas' | 'embora' | 'pois' ;

adverbio de predicado = adverbio de tempo
                      | adverbio de lugar
                      | adverbio de modo ;

adverbio de afirmacao   = 'sim' | 'certo' ;
adverbio de negacao     = 'não' | 'nem' | 'nunca' | 'jamais' ;
adverbio de interogacao = 'como' | 'onde' | 'quando' | 'porque'
adverbio de tempo       = 'ainda'
                        | 'afinal'
                        | 'anteontem'| 'ontem'  | 'hoje' | 'amanhã'
                        | 'antes'    | 'agora'  | 'após' | 'depois' 
                        | 'breve'
                        | 'cedo'  | 'tarde'
                        | 'enfim' | 'então'
                        | 'já' | 'logo' 
                        | 'nunca' | 'jamais' | 'sempre'
                        | 'outrora'
                        | 'quando' ;
adverbio de lugar       = 'abaixo'  | 'acima' | 'debaixo' | 'embaixo'
                        | 'adiante' | 'diante' | 'afora'
                        | 'algures'
                        | 'aqui' | 'aí' | 'ali' | 'acolá' | lá'
                        | 'além' | 'aquém'
                        | 'atrás'   | 'através'
                        | 'antes' | 'depois'
                        | 'cá'
                        | 'detrás'
                        | 'defronte'
                        | 'dentro'  | 'fora'
                        | 'junto'
                        | 'longe' | 'perto' 
                        | 'onde' ;
adverbio de quantidade  = adverbio de intensidade ;
adverbio de intensidade = 'apenas'
                        | 'bastante' | 'bem'
                        | 'demais'  | 'demasiado'
                        | 'mais'    | 'menos'
                        | 'muito' | 'pouco'
                        | 'tudo'  | 'nada'
                        | 'quão'  | 'quanto'  | 'quase'
                        | 'tão'   | tanto' ;
adverbio de modo        = 'assim'
                        | 'bem' | 'mal'
                        | 'melhor' | 'pior'
                        | 'como'
                        | 'contra'
                        | 'debalde' | 'depressa' | 'devagar'
                        | 'sobretudo' | 'também' ;
adverbio de duvida      = 'acaso' | 'porventura' | 'quiçá' | 'talvez' ;
adverbio de inclusao
          e exclusao = 'apenas' | 'até'
                     | 'exclusive' | 'inclusive'
                     | 'exceto'
                     | 'fora'
                     | 'menos'
                     | 'sequer' | 'só' | 'somente'
                     | 'também' ;
adverbio de demonstracao  = 'eis' ;

classe fechada  = determinante | pronome | preposicao | conjuncao | contracao ;

determinante      = determinante artigo
                  | determinante demonstrativo
                  | determinante possesivo
                  | determinante indefinido
                  | determinante relativo
                  | determinante interrogativo ;

determinante artigo = artigo definido | artigo indefinido ;
artigo definido     = 'a' | 'as' | 'o' | 'os' ;
artigo indefinido   = 'uma' | 'umas'  | 'um'  | 'uns' ;

determinante demonstrativo = 'esta'   | 'estas    | 'este'   | 'estes'
                           | 'essa'   | 'essas'   | 'esse'   | 'esses'
                           | 'aquela' | 'aquelas' | 'aquele' | 'aqueles' ;

determinante possesivo  = 'minha' | 'minhas' | 'meu'   | 'meus'
                        | 'tua'   | 'tuas'   | 'teu'   | 'teus'
                        | 'sua'   | 'suas'   | 'seu'   | 'seus'
                        | 'nossa' | 'nossas' | 'nosso' | 'nossos'
                        | 'vossa' | 'vossas' | 'vosso' | 'vossos' ;

determinante indefinido = 'certa' | 'certas'  | 'certo' | 'certos'
                        | 'outra' | 'outras'  | 'outro' | 'outros' ;
                          
determinante relativo   = 'cujo' | 'cuja' | 'cujos' | 'cujas' ;

determinante interrogativao = 'que' | 'qual'  | 'quais' ;

pronome = pronome pessoal
        | pronome demonstrativo
        | pronome possesivo
        | pronome indefinido
        | pronome relativo
        | pronome interrogativo ;

pronome pessoal = 'eu'  | 'tu'  | 'ela' | 'ele' | 'nós' | 'elas' | 'eles'
                | 'mim' | 'ti'  | 'si'
                | 'a' | 'as' | 'o' | 'os'
                | 'comigo'  | 'contigo' | 'consigo' | 'conosco' | 'convosco' ;

pronome demonstrativo = 'esta'  | 'estas    | 'este'  | 'estes'
                      | 'essa'  | 'essas'   | 'esse'  | 'esses'
                      | 'aquela'| 'aquelas' | 'aquele'| 'aqueles' ;

pronome possesivo     = 'minha' | 'minhas'  | 'meu'   | 'meus'
                      | 'tua'   | 'tuas'    | 'teu'   | 'teus'
                      | 'sua'   | 'suas'    | 'seu'   | 'seus'
                      | 'nossa' | 'nossas'  | 'nosso' | 'nossos'
                      | 'vossa' | 'vossas'  | 'vosso' | 'vossos' ;

pronome indefinido    = 'certa' | 'certas'  | 'certo' | 'certos'
                      | 'outra' | 'outras'  | 'outro' | 'outros' ;
                          
pronome relativo      = 'cuja'  | 'cujas'   | 'cujo'  | 'cujas'

pronome interrogativo = 'que' | 'qual' | 'quais'

quantificador = quantificador universal
              | quantificador existencial
              | quantificador numeral
              | quantificador interrogativo
              | quantificador relativo ;

quantificador universal   = 'toda'    | 'todas'   | 'todo'    | 'todos'
                          | 'nenhuma' | 'nenhumas | 'nenhum'  | 'nenhuns'
                          | 'ambos'   | 'cada'    | 'qualquer' ;

quantificador existencial = 'alguma'  | 'algumas' | 'algum'   | 'alguns'
                          | 'algo'    | 'alguém' ;

(* por concluir *)
quantificador numeral = ;
quantificador interrogativo = ;
quantificador relativo      = ;

quantificador = 'quanto'  | 'Quanto' ;

preposicao  = preposicao essencial | presposicao acidental ;
preposicao essencial  = 'ante'
                      | 'com'   
                      | 'de'    | 'desde'
                      | 'em'    | 'entre'   | 
                      | 'para'  | 'perante'
                      | 'sem'   | 'sob'
                      | 'trás' ;
preposicao acidental  = 'a'     | 'após'      | 'até'
                      | 'como'  | 'conforme'  | 'contra'
                      | 'durante'
                      | 'exceto'
                      | 'fora'
                      | 'mais'
                      | 'menos'
                      | 'por'
                      | 'que'
                      | 'salvo'
                      | 'senão'
                      | 'sobre'
                      | 'mediante' ;
                    
conjuncao = conjuncao coordenativa
          | conjuncao subordinativa

conjuncao coordenativa  = conjuncao copulativa
                        | conjuncao disjuntiva
                        | conjuncao conclusiva
                        | conjuncao adversativa
                        | conjuncao explicativa ;

conjuncao copulativa  = 'e' | 'nem' | 'também' ;
conjuncao disjuntiva  = 'ou' ;
conjuncao conclusiva  = 'assim' | 'logo'| 'pois' | 'portanto' ;
conjuncao adversativa = 'contudo' | 'mas' | 'porém' | 'todavia' ;
conjuncao explicativa = 'pois' | 'porquanto' | 'porque' | 'que' ;

conjuncao subordinativa = conjuncao completiva
                        | conjuncao causal
                        | conjuncao final
                        | conjuncao temporal
                        | conjuncao concessiva
                        | conjuncao condicional
                        | conjuncao comparativa
                        | conjuncao consecutiva ;

conjuncao completiva    = 'que' ;
conjuncao causal        = 'como' | 'pois' | 'porquanto' | 'porque' | 'que' ;
conjuncao final         = 'que' ;
conjuncao temporal      = 'apenas' | 'mal' | 'quanto' | 'enquanto' ;
conjuncao concessiva    = 'conquanto' | 'embora' | 'que' ;
conjuncao condicional   = 'se' | 'senão' | 'caso' ;
conjuncao comparativa   = 'como' | 'conforme' ;
conjuncao consecutiva   = 'que' ; (* quando *)

contracao =
          (*  a + art.  *)
          | 'à'   | 'às'  | 'ao   | 'aos'
          (*  a + pron. dem.  *)
          | 'àquela' | 'àquelas'| 'àquele' | 'àqueles'
          (*  a + adv.  *)
          | 'aonde' | 'Aonde'
          (*  de + art. *)
          | 'da'    | 'das'   | 'do'  | 'dos'
          | 'duma'  | 'dumas' | 'dum' | 'duns'
          (*  de + pron. pess. *)
          | 'dela'    | 'delas'   | 'dele'    | 'deles'
          (*  de + pron. dem.  *)
          | 'desta'   | 'destas'  | 'deste'   | 'destes'
          | 'dessa'   | 'dessas'  | 'desse'   | 'desses'
          | 'daquela' | 'daquelas'| 'daquele' | 'daqueles'
          | 'daquilo'
          | 'Daquilo'
          (*  de + pron. indef. *)
          | 'doutra'  | 'doutras' | 'doutro'  | 'doutros'
          (*  de + adv. ou de + prep. *)
          | 'daqui' | 'daí' | 'dali' | 'daquém' | 'dalém' | 'dentre'
          | 'dantes' | 'dacolá' | 'donde'
          (*  em + art. *)
          | 'na'  | 'nas' | 'no'  | 'nos'
          | 'numa'  | 'numas' | 'num'   | 'nuns'
          (*  em + pron. pess. *)
          | 'nela'    | 'nelas'   | 'nele'    | 'neles'
          (*  em + pron. dem.  *)
          | 'neste'   | 'nesta'   | 'nestes'  | 'nestas
          | 'nesse'   | 'nessa'   | 'nesses'  | 'nessas'
          | 'naquele' | 'naquela' | 'naqueles'| 'naquelas'
          | 'naquilo'
          (*  em + pron. indef. *)
          | 'noutro'  | 'noutra'  | 'noutros' | 'noutras'
          (*  por + pron. pess.  *)
          | 'pelo'    | 'pela'    | 'pelos'   | 'pelas'
          ;

diversa   = 'como'  (* verb.       *)
          | 'qual'  (* conj. *)
          | 'quais' (* conj. *)
          | 'se'            (* pron.    *)
          | 'caso'          (* n.m, v.  *)
          | 'exceto'       (* adj., adv.   *)
          | 'mediante'      (* adj. *)
          | 'conforme'      (* adj. 2 g. | adv. | conj. | prep. *)
          | 'consoante'     (* adj. 2 g. | n. f. | prep. *)
          | ? a ser definidos num arquivo separado ? ;
```
