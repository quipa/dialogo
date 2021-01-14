grammar Gramatica;

@header {
package org.quipa.dialogo; }


// frases
documento       : (frase)+ ;
frase           : declaracao | interrogacao | definicao ;
declaracao      : periodo '.' ;
interrogacao    : periodo '?' ;
definicao       : oracao (precedencia)? ':' (frase)+ '!' ;
precedencia     : '::' NUMERO (NUMERO)? ;

// período e oração
periodo         : oracao (';' (oracao ',' oracao)+)+ ;
oracao          : (ESPACO)? termo (ESPACO termo)+ ;
termo           : ITEM | grupo ;
grupo           : expressao | bloco | padrao | texto | comentario ;

// grupos de código
expressao       : '[' (oracao | (frase)+) ']' ;
bloco           : '{' (oracao | (frase)+) '}' ;
padrao          : '(' (operadorKleene)? (oracao | (frase)+) ')' ;
operadorKleene  : OPCAO_KLEENE | SOMA_KLEENE | ESTRELA_KLEENE ;

// texto
texto           : textoNormal | textoLiteral | textoBruto ;
textoNormal     : '\'' (~('\'' | '\\') | escapeTexto)* '\'' ;
textoLiteral    : '"' (~('"' | '\\') | '\\' .)* '"' ;
textoBruto      : 'b"' .*? '"' ;
escapeTexto     : '\\' (expressao | bloco | padrao | .) ;

// comentário
comentario          : '#' .*? '\n' | comentarioExpressao |
                    | comentarioBloco | comentarioPadrao ;
comentarioExpressao : '#[' (comentarioConteudo)? ']'  ;
comentarioBloco     : '#{' (comentarioConteudo)? '}'  ;
comentarioPadrao    : '#(' (comentarioConteudo)? ')'  ;
comentarioConteudo  : comentario | . ;

// item
ITEM            : PALAVRA | NUMERO | SIMBOLO | LITERAL ;
PALAVRA         : (LETRA)+ ;
NUMERO          : (DIGITO)+ (',' (DIGITO)+)? ;
SIMBOLO         : ~([\p{Letter}] | [0-9]
                | '.' | '?' | '!'
                | ',' | ';' | ':'
                | '[' | ']' | '{' | '}' | '(' | ')' | '\'' | '"'
                | '\\' ) ;
LITERAL         : '\\' [^\\]*? ;
ESPACO          : [\s]+ -> skip ;

// operadores kleene
OPCAO_KLEENE    : '?' ;
SOMA_KLEENE     : '+' ;
ESTRELA_KLEENE  : '*' ;

fragment LETRA  : [\p{Letter}] ;
fragment DIGITO : [0-9] ;
