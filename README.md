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

## Sintáxe e Semántica

A sintáxe será predominantemente dinâmica, podendo ser redefinada em tempo real. A pontuação da linguagem tem regras fixas, alterando como a linguagem é lida (avaliada). As frases são declarações, interrogações (perguntas), definições.

Exemplos (assumindo algumas regras pré-definiadas):
* Declarar um facto: `A Maria é uma agricultora.`
* Definir uma regra: `{Uma pessoa} é um agricultor: A pessoa planta (algo)!`
* Perguntar sobre um facto ou regra. `O José é um apicultor?`
* Declarar factos em simuláneo: `(A Maria e o José) são quilombolas.`
* Definir várias regras: `(Um agricultor ou uma agricultora) é criador de ovelha: O agricultor cria ovelha; a agricultora cria ovelha!`
* Perguntar sobre vários factos: `(A Ana e o Pedro) são criadores de cabra?` faz uma pergunta sobre a Ana e o Pedro.
Perguntar sobre um facto (com um expressão de aritmética): `O Pedro produziu [10 quilos * 2 hectares] de milho? `
Declarar um facto de acordo com uma condição:
```
Se {o Pedro tiver certificado orgânico} então {
  O Pedro planta 2 hectares de algodão consorciado e 2 hectares de consórcio de milho.}
senão {
  O Pedro planta 4 hectares de consórcio de milho.
}
```
Declarar um facto repetidamente:
```
O Lucas repete 50 vezes {
  Ele cava um berço.
  Ele planta uma semente.
  Ele cobre o berço.
  Ele rega o berço.
  Ele avança 1 metros para sudeste.
}
```

A linguagem terá a seguinte sintaxe fixa para a pontuação (EBNF):

```
(* frases *)
frase           = declaração | interrogação | definição ;
declaração      = oração , "." ;
interrogação    = oração , "?" ;
definição       = oração , [ precedência ] ":" , { frase } , "!" ;
precedência     = "::" número [ número ] ;

(* oração e construção *)
oração          = construção , { ";" , construção };
construção      = { termo } | ( construção , "," , construção ) ;
termo           = item | grupo ;
grupo           = expressão | bloco | padrão | texto | texto extenso ;


(* grupos *)
expressão       = "[" , oração | { frase } , "]" ;
bloco           = "{" , oração | { frase } , "}" ;
padrão          = "(" , oração | { frase } , ")" ;
texto           = texto normal | texto literal ;
texto normal    = "'" , oração | { frase } , "'" ;
texto literal   = '"' , oração | { frase } , '"' ;
comentário      = '"""' , { oração | frase } , '"""'

(* item *)
item          = palavra | número | símbolo | literal
palavra       = { ? carateres latinos ? } ;
número        = ? inteiro, real ? ;
símbolo       = ? caratere ? - palavra - número - pontuação ;
literal       = "\" , termo ;

(* pontuação *)
pontuação     = finalizador | separador | delimitador | "\" ;
finalizar     =  "." | "?" | "!" ;
separador     = "," | ";" | "::" | ":" ;
delimitador   = "{" | "}" | "[" | "]" | "(" | ")" | "'" | '"' | ;
```

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

## Implementação
Serão publicados protótipos de interpretadores da linguagem para testagem. O primeiro protótipo será implementado na linguagem [Tcl](https://pt.wikipedia.org/wiki/Tcl) por ser uma linguagem extremamente flexível. Outras possíveis implementações de teste serão criadas em [Racket](https://pt.wikipedia.org/wiki/Racket) e e [Python](https://pt.wikipedia.org/wiki/Python). 


Os interpretadores serão baseados no algoritmo Top Down Operator Precedence desenvolvido por Vaughan Pratt, usados na antiga linguagem [CGOL](https://en.wikipedia.org/wiki/CGOL) desenvolvida nos anos 70.

A linguagem suportará os seguintes paradigmas:
* Orientado à objetos
* Funcional
* Lógico

Em termos de paradigma de orientação à objetos, a linguagem suportará herança múltipla e despacho múltiplo, facilitando a criação de redes semânticas entre diferentes sujeitos, verbos e objetos.
Em termos do paradigma lógico, a linguagem será baseado numa base de factos e procedimentos (comandos, pedidos e perguntas).
Em termos funcionais, definições dentro sem palavras chave pode ser considerada expressões lambda

