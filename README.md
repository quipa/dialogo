# Dialogo
Uma linguagem para diálogo entre humanos e computadores.

## Objetivo
Criar e usar sistemas interativos de informação de modo simples e fléxivel.

## Requisitos
* DEVE ser fácil de ler, escrever e compreender por pessoas que tenham uma educação de ensino médio Brasileiro;
* DEVE ser fácil de ler e compreender por pessoas que tenham uma educação básica com auxílio de terceiros.
* DEVE ser fácil de aprender e ensinar num curto espaço de tempo;
* DEVE ser baseada em Português e ter uma sintaxe e semântica quase natural;
* DEVE ser possível criar, pesquisar, atualizar e apagar informações;
* DEVE permitir armazenar informações num formato textual legível para humanos;
* DEVE ser fácil de instalar e configurar, o instalador NÃO DEVE depender de conexão de Internet, mas PODE utilizá-la se houver uma conexão;
* DEVE ser bem definida e não-ambígua em termos computacionais;
* PODE facilitar a integração de sistemas de informação e conhecimento existentes (através de API, bindings e protocolos);
* PODE permitir a criação de interfaces gráficas para sistemas de informação.

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

**Em construção**

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

**Em construção**

## Inspiração
A linguagem é filosoficamente inspirada pela linguagem [Logo](http://pt.wikipedia.org/wiki/Logo) (Dia*Logo*) concebida por [Seymour Papert](http://pt.wikipedia.org/wiki/Seymour_Papert), [Wally Feurzeig](https://en.wikipedia.org/wiki/Wally_Feurzeig), [Cynthia Solomon](https://en.wikipedia.org/wiki/Cynthia_Solomon) e a linguagem [Smalltalk](http://pt.wikipedia.org/wiki/Smalltalk) (literalmente significa conversa fiada) concebida por [Alan Kay](http://pt.wikipedia.org/wiki/Alan_Kay), [Dan Ingalls](https://en.wikipedia.org/wiki/Dan_Ingalls) e [Adele Goldberg](https://en.wikipedia.org/wiki/Adele_Goldberg_(computer_scientist)), ambas baseadas na filosofia do construcionismo.

Ela é baseada em conceitos de linguística cognitiva:
* **[construções](http://en.wikipedia.org/wiki/Construction_grammar)**, frases incompletas com padrões (*slots*) que podem ser preenchidos.
* **[Combinadores gramaticais](https://pt.wikipedia.org/wiki/Gramática_categorial_combinatória)** associam a cada palavra um combinador que permite construir frases.

Outras linguagens de programação que influenciam a proposta:
* Logo
* Smalltalk
* [Lisp](http://en.wikipedia.org/wiki/Lisp_(programming_language))/[Scheme](http://en.wikipedia.org/wiki/Scheme_(programming_language))
* [Prolog](http://en.wikipedia.org/wiki/Prolog)
* [Inform 7](http://inform7.com/)
* [Attempto Controlled English](http://attempto.ifi.uzh.ch/site/)
* [Rebol](http://www.rebol.com/)
* [HyperTalk](http://en.wikipedia.org/wiki/HyperTalk)
* [Dylan](http://en.wikipedia.org/wiki/Dylan_(programming_language))
* [Tcl](http://www.tcl.tk/)
* [CGOL](http://en.wikipedia.org/wiki/CGOL)
* [Raku](https://www.raku.org/)
* [Kernel](https://web.cs.wpi.edu/~jshutt/kernel.html)
* [Go!](https://en.wikipedia.org/wiki/Go!_(programming_language)) (não confundir com [Go](golang.org/))

## Implementação
Atualmente o projeto está a considerar utilizar a plataforma Java para implementação e suas diversas linguagens, devido a sua máquina virtual (JVM) e bibliotecas (APIs).

A primeira implementação será um interpretador de árvore baseado no algoritmo *Top Down Operator Precedence* desenvolvido por Vaughan Pratt desenvolvido nos anos 70 (e aplicado na linguagem CGOL.

## <a name="gramatica"></a> Gramáticas

Seguem duas definições da gramática fixa da linguagem. Ambas devem ser interpretadas como gramáticas [GASE](https://pt.wikipedia.org/wiki/Gramática_de_análise_sintática_de_expressão) (*[PEG](https://en.wikipedia.org/wiki/Parsing_expression_grammar)*) com alternativas selecionadas da esquerda para a direita.

#### Gramática em Dialogo

A seguinte gramática usa a sintaxe da própria linguagem Dialogo.

* `coisa`             não-terminal sintático ou léxico (identificador);
* `COISA`             não-terminal morfológico (um identificador);
* `coisa composta`    não-terminal sintático-léxico (identificador composto);
* ``COISA COMPOSTA``  não terminal morfológico (identificador composto);
* `'coisa'`           terminal (texto);
* `"coisa"`           terminal (texto);
* `(coisa1 coisa2)`   padrão;
* `# coisa #`         comentário;

Assume-se que os seguintes operadores estão definidos

* `coisas ->> coisa.`   define uma regra gramatical (operador árvore);
* `coisa1 | coisa2`     regras alternativas;
* `coisa1 - coisa`      excepção à regra;
* `(* coisa)`           padrão para zero ou mais `coisa`s;
* `(+ coisa)`           umpadrão para uma ou mais `coisa`s;
* `(~ coisa)`           padrão opcional para uma `coisa`.

Precedência dos operadores.
`-` > `|` > `*` `+` `~` > `->>`

```dialogo
###################
Gramática Sintática
###################

documento     ->> parágrafo (~ espaços).
parágrafo     ->> frase (* espaços frase).

frase         ->> declaração | interrogação | exclamação.
declaração    ->> período '.'.
interrogação  ->> período '?'.
exclamação    ->> período '!'.

período       ->> procedimento | macro | oração.

procedimento  ->> função | comando | regra | tipo.
função        ->> 'função'  (~ oração) bloco.
comando       ->> 'comando' (~ oração) bloco.
regra         ->> 'regra'   oração bloco.
tipo          ->> 'tipo' (~ identificador) bloco.

macro         ->> 'macro ' procedimento.
oração        ->> (~ espaços) termo (* espaços termo).

termo         ->> item | grupo | lista.

item          ->> variável | chave | `variável chave` | identificador
                | literal | misto | comentário.
literal       ->> número | texto.

grupo         ->> expressão | bloco | padrão.
expressão     ->> '[' (período | parágrafo) (~ espaços) ']'.
bloco         ->> '{' (período | parágrafo) (~ espaços) '}'.
padrão        ->> '(' período (~ espaços) ')'.

lista         ->> (item - chave | grupo)
                  (+ ';' espaços (item - chave | grupo)).

#################
Gramática Lexical
#################

espaços       ->> (+ ESPAÇO).

variável          ->> ':' IDENTIFICADOR.
chave             ->>     IDENTIFICADOR ':'.
`variável chave`  ->> ':' IDENTIFICADOR ':'.

identificador ->> IDENTIFICADOR (* ':' (IDENTIFICADOR | LITERAL)).

número        ->> real | fracional | inteiro.
real          ->> ('-' | '+') NÚMERO ',' NÚMERO.
racional      ->> ('-' | '+') NÚMERO '/' NÚMERO.
inteiro       ->> decimal | binário | octal | hexadecimal.
decimal       ->> ('-' | '+') NÚMERO.
binário       ->> '0b' NÚMERO.
octal         ->> '0o' NÚMERO.
hexadecimal   ->> '0x' NÚMERO.

texto         ->> TEXTO.

misto         ->> MISTO.

comentário    ->> COMENTÁRIO.

#####################
Gramática Morfológica
#####################

IDENTIFICADOR ->> RESERVADO | PALAVRA | OPERADOR | COMPOSTO.

RESERVADO     ->> 'macro' | 'função' | 'comando' | 'regra' | 'tipo' | LÉXICO.
PALAVRA       ->> (+ LETRA).
OPERADOR      ->> (+ SÍMBOLO).
COMPOSTO      ->> '`' (+  CORINGA - '`' | '\`') '`'.

LITERAL       ->> NÚMERO | TEXTO.

NÚMERO        ->> (+ DÍGITO).

TEXTO         ->> "'" (* CORINGA - "'" | "\'") "'
                | '"' (* CORINGA - '"' | '\"') '"'
                | '«' (* CORINGA - '»' | '\»') '»' ;

MISTO         ->> CARATERE (* CARATERE | SINAL) CARATERE.

COMENTÁRIO    ->> (+ '#') (+ CORINGA - '#' | '\#') (+ '#').

LÉXICO        ->> `VERBO DE LIGAÇÃO` | ADVÉRBIO | DETERMINANTE | PRONOME
                | QUANTIFICADOR | PREPOSIÇÃO | CONJUNÇÃO | CONTRAÇÃO.

#########
Carateres
#########

CORINGA   ->> ESPAÇO | CARATERE | SINAL.

ESPAÇO    ->> ' ' | '\n' | '\t'.

CARATERE  ->> LETRA | DÍGITO | SÍMBOLO.
SINAL     ->> PONTO | DELIMITADOR.

LETRA     ->> 'a' | 'b' | 'c' | 'd' | 'e' | 'f' | 'g' | 'h' | 'i' | 'j' | 'k'
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
            | 'Â' | 'Ê' | 'Ô'.

DÍGITO    ->> '0' | '1' | '2' | '3' | '4' | '5' | '6' | '7' | '8' | '9'.
SÍMBOLO   ->> '+' | '-' | '*' | '/' | '=' | '<' | '>' | '%' | '|' | '&'
            | '$' | '@' | '\' | '_' | '~' | '^'.

PONTO         ->> '.' | '?' | '!' | ':' | ';' | ','.
DELIMITADOR   ->> '[' | ']' | '{' | '}' | '(' | ')'
                | '`' | "'" | '"' | '«' | '»' | '#'.

```

### Gramática EBNF

Gramática em formato [EBNF](https://pt.wikipedia.org/wiki/Formalismo_de_Backus-Naur_Estendido), mas deve ser interpretada como uma gramática PEG, com as primeiras regras tendo precedência às segundas.

**NOTA: Realce de sintaxe do Github não reconhece carateres latinos por isso não são usados acentos ou cedilhas nesta gramática**

```EBNF
(*******************
 Gramatica Sintatica
 *******************)

documento     = paragrafo , [ espacos ] ;
paragrafo     = frase , { espacos , frase } ;

frase         = declaracao | interrogacao | exclamacao ;
declaracao    = periodo , '.' ;
interrogacao  = periodo , '?' ;
exclamacao    = periodo , '!' ;

periodo       = procedimento | macro | oracao ;

procedimento  = funcao | comando | regra | tipo ;
funcao        = 'função'  , [ oracao ] , bloco ;
comando       = 'comando' , [ oracao ] , bloco ;
regra         = 'regra'   , oracao , bloco ;
tipo          = 'tipo' , [ identificador ] , bloco ;

macro         = 'macro ' , procedimento ;

oracao        = [ espacos ] , termo , { espacos , termo } ;

termo         = item | grupo | lista ;

item          = variavel | chave | variavel chave | identificador
              | literal | comentario | misto ;
literal       = numero | texto ;

grupo         = expressao | bloco | padrao ;
expressao     = '[' , ( periodo | paragrafo ) , [ espaços ] , ']'.
bloco         = '{' , ( periodo | paragrafo ) , [ espaços ] , '}'.
padrao        = '(' , período , [ espaços ] , ')'.

lista         = ( item - chave | grupo ) ,
                ( ';' , espaços , ( item - chave | grupo ) ) ,
                { ';' , espaços , ( item - chave | grupo } ;

(*****************
 Gramatica Lexical
 *****************)

espacos       = ESPACO , { ESPACO } ;

variavel        = ':' , IDENTIFICADOR ;
chave           =     , IDENTIFICADOR , ':' ;
variavel chave  = ':' , IDENTIFICADOR , ':' ;

identificador = IDENTIFICADOR , { ':' , ( IDENTIFICADOR | LITERAL ) } ;

numero        = real | fracional | inteiro.
real          = ('-' | '+') , NUMERO , ',' , NUMERO ;
racional      = ('-' | '+') , NUMERO , '/' , NUMERO ;
inteiro       = decimal | binario | octal | hexadecimal ;
decimal       = ('-' | '+') , NUMERO.
binario       = '0b' , NUMERO ;
octal         = '0o' , NUMERO ;
hexadecimal   = '0x' , NUMERO ;

texto         = TEXTO ;

comentario    = COMENTARIO ;

misto         = MISTO ;

(*********************
 Gramatica Morfologica
 *********************)

IDENTIFICADOR = RESERVADO | PALAVRA | OPERADOR | COMPOSTO.

RESERVADO     = 'macro' | 'função' | 'comando' | 'regra' | 'tipo' | LEXICO ;
PALAVRA       = LETRA , { LETRA } ;
OPERADOR      = SIMBOLO , { SIMBOLO } ;
COMPOSTO      = '`' , CORINGA { CORINGA - '`' | '\`' } , '`' ;

LITERAL       = NUMERO | TEXTO ;

NUMERO        = DIGITO { DIGITO } ;

TEXTO         = "'" , { CORINGA - "'" | "\'" } , '"'
              | '"' , { CORINGA - '"' | '\"' } , '"'
              | '«' , { CORINGA - '»' | '\»' } , '»' ;

MISTO         = CARATERE , { CARATERE | SINAL } , CARATERE ;

COMENTARIO    = '#' , { '#' } , ( CORINGA - '#' | '\#' ) ,
                { CORINGA - '#' | '\#' } , '#' , { '#' } ;

LEXICO        = VERBO DE LIGACAO | ADVERBIO | DETERMINANTE | PRONOME
              | QUANTIFICADOR | PREPOSICAO | CONJUNCAO | CONTRACAO.


(***********************************
 Carateres

 Ver seccoes na gramatica em dialogo
 ***********************************)



```

