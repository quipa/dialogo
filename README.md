# Dialogo
Uma linguagem para diálogo entre humanos e computadores.

## Objetivo
Permitir qualquer pessoa criar sistemas e bancos de informação e conhecimento interativos.

## Requisitos

* DEVE ser fácil de ler, compreender e ser usada por qualquer pessoa.
* DEVE ser fácil de aprender e ensinar num curto espaço de tempo.
* DEVE ser baseada em Português e ter uma sintáxe e semântica semelhante à linguagem natural, mas DEVE ser formalmente definida e não-ambígua.
* DEVE permitir conceber e criar sistemas de informação e conhecimento e permitir criar, ler, atualizar e apagar informações.
* DEVE ser fácil de instalar e configurar e NÃO DEVE depender de conexão de Internet para tal, mas PODE utilizá-la se houver uma conexão.
* PODE facilitar a a integração de sistemas de informação e conhecimento existentes (através de API, bindings e protocolos)
* PODE permitir a criação de interfaces gráficas para sistemas de informação

## Histórico
Esta linguagem foi inspirada por experiências de ensino/aprendizado do [Projeto Quipá](https://www.facebook.com/projetoquipa/) durante a sua campanha "Ação no Sertão" de 2019 no Território Serra da Capivara, Piauí, Brasil. Durante esta campanha foram organizados cursos em colaboração com a [Cáritas Diocesana de São Raimundo Nonato](https://www.facebook.com/CaritasSRN/) junto com comunidades rurais, técnicos e profissionais de extensão e estudantes de ensino técnico da Escola Família Agrícola da Serra da Capivara.

A linguagem está sendo concebida por Maxim Simões de Abreu Jaffe no âmbito do mestrado em Gestão dos Recursos Naturais da [Universidade de Trás-os-Montes e Alto Douro, Portugal](https://www.utad.pt/). Será utilizada futuramente para extensão rural e agroecológica em comunidades rurais e urbanas no Território Serra da Capivara, Piauí, Brasil.

## Inspiração
A linguagem é filosoficamente inspirada pela linguagem [Logo](https://pt.wikipedia.org/wiki/Logo) (Dia*Logo*) concebida por [Seymour Papert](https://pt.wikipedia.org/wiki/Seymour_Papert) e a linguagem [SmallTalk](https://pt.wikipedia.org/wiki/Smalltalk) (literalmente significa conversa fiada) concebida por [Alan Kay](https://pt.wikipedia.org/wiki/Alan_Kay) . Ela é baseada em princípios da linguística cognitiva, particularmente a ideia de "construções", frases com espaços que podem ser completadas.

Outras linguagens de programação que influenciam a proposta:
* Lisp/Scheme
* Prolog
* Inform 7
* Rebol
* HyperTalk
* Dylan
* Tcl
* CGOL

## Sintáxe e Semántica

A sintáxe será predominantemente dinâmica, podendo ser redefinada em tempo real. A linguagem terá a seguinte sintaxe pré-definida (EBNF):

```
(* frases *)
frase           = declaração | interrogação | definição;
declaração      = oração , ".";
interrogação    = oração , "?";
definição       = oração , ":" , { frase } , "!";

(* oração e construção *)
oração          = construção , { ";" , construção };
construção      = { termo } | ( construção , "," , construção ) ;
termo           = item | grupo ;
grupo           = expressão | bloco | padrão | texto | texto extenso


(* grupos *)
expressão       = "[" { oração | frase } "]" ;
bloco           = "{" { oração | frase } "}" ;
padrão          = "(" { oração | frase } ")" ;
texto           = texto literal | texto curto | texto extenso ;
texto curto     = "'" { oração | frase } "'" ;
texto extenso   = '"' { oração | frase } '"' ;
texto literal   = "''" { oração | frase } "''" ;

(* item *)
item          = palavra | número | símbolo | literal ;
palavra       = { ? carateres latinos ? } ;
número        = ? inteiro, real ? ;
símbolo       = ? caratere ? - palavra - número - pontuação ;
literal       = "\" , termo ;
pontuação     = "," | ";" | "." | "?" | ":" | "!" | "{" | "}" | "[" | "]" | "(" | ")" | "'" | '"' | "\" ;
```

A pontuação define como é "lido" (avaliado) o código.


## Implementação
Serão publicados protótipos de interpretadores da linguagem para testagem. O primeiro protótipo será implementado na linguagem [Tcl](https://pt.wikipedia.org/wiki/Tcl) por ser uma linguagem extremamente flexível. Outras possíveis implementações de teste serão criadas em [Racket](https://pt.wikipedia.org/wiki/Racket) e e [Python](https://pt.wikipedia.org/wiki/Python). 


Os interpretadores serão baseados no algoritmo Top Down Operator Precedence desenvolvido por Vaughan Pratt, usados na antiga linguagem [CGOL](https://en.wikipedia.org/wiki/CGOL) desenvolvida nos anos 70.

A linguagem suportará os seguintes paradigmas:
* Orientado à objetos
* Funcional
* Lógico

Em termos de paradigma de orientação à objetos, a linguagem suportará herança múltipla e despacho múltiplo, facilitando a criação de redes semânticas entre diferentes sujeitos, verbos e objetos.
Em termos do paradigma lógico, a linguagem será baseado numa base de factos e procedimentos (comandos, pedidos e perguntas).


