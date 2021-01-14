grammar Gramatica;

@header {
package org.quipa.dialogo; }


// frases
documento       : (frase)+ ;
frase           : declaração | interrogação | definição ;
declaração      : período '.' ;
interrogação    : período '?' ;
definição       : oração (precedência)? ':' (frase)+ '!' ;
precedência     : '::' NÚMERO (NÚMERO)? ;

// período e oração
período         : oração (';' (oração ',' oração)+)+ ;
oração          : (ESPAÇO)? termo (ESPAÇO termo)+ ;
termo           : ITEM | grupo ;
grupo           : expressão | bloco | padrão | texto | comentário ;

// grupos de código
expressão       : '[' (oração | (frase)+) ']' ;
bloco           : '{' (oração | (frase)+) '}' ;
padrão          : '(' (oração | (frase)+) ')' ;

// texto
texto           : textoNormal | textoLiteral | textoBruto ;
textoNormal     : '\'' (~('\'' | '\\') | escapeTexto)* '\'' ;
textoLiteral    : '"' (~('"' | '\\') | '\\' .)* '"' ;
textoBruto      : 'b"' .*? '"' ;
escapeTexto     : '\\' (expressão | bloco | padrão | .) ;

// comentário
comentário          : '#' .*? '\n' | comentárioExpressão |
                    | comentárioBloco | comentárioPadrão ;
comentárioExpressão : '#[' (comentárioContéudo)? ']'  ;
comentárioBloco     : '#{' (comentárioContéudo)? '}'  ;
comentárioPadrão    : '#(' (comentárioContéudo)? ')'  ;
comentárioContéudo  : comentário | . ;

// item
ITEM            : PALAVRA | NÚMERO | SÍMBOLO | LITERAL ;
PALAVRA         : (LETRA)+ ;
NÚMERO          : (DIGÍTO)+ (',' (DIGÍTO)+)? ;
SÍMBOLO         : [^\\[\]{}().?!,;:'"] ;
LITERAL         : '\\' [^\\]*? ;
ESPAÇO          : [\s]+ -> skip ;

fragment LETRA  : [\p{Letter}] ;
fragment DIGÍTO : [0-9] ;
