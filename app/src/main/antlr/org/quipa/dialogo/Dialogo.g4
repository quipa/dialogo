grammar Dialogo;

// frases
frase           : declaração | interrogação | definição ;
declaração      : oração '.' ;
interrogação    : oração '?' ;
definição       : oração (precedência)? ':' (frase)+ '!' ;
precedência     : '::' NÚMERO (NÚMERO)? ;

// oracao e construção
oração          : construção (';' construção) ;
construção      : (ESPAÇO)* termo (ESPAÇO termo)+ | construção ',' construção ;
termo           : ITEM | grupo ;
grupo           : expressão | bloco | padrão | texto | comentário ;

// grupos
expressão       : '[' (oração | (frase)+) ']' ;
bloco           : '{' (oração | (frase)+) '}' ;
padrão          : '(' (oração | (frase)+) ')' ;
texto           : textoNormal | textoLiteral ;
textoNormal     : '\'' (oração | (frase)+) '\'' ;
textoLiteral     : '"' (oração | (frase)+) '"' ;
comentário      : '"""' (oração | (frase)+) '"""' ;

ITEM            : PALAVRA | NÚMERO | SÍMBOLO | LITERAL;
PALAVRA         : (LETRA)+ ;
NÚMERO          : (DIGÍTO)+ (',' (DIGÍTO)+)? ;
SÍMBOLO         : [^\\.?!,;:{}[\]()'"] ;
LITERAL         : '\\' ITEM ;
ESPAÇO          : [\s]+ -> skip;

fragment LETRA          : [\p{Letter}] ;
fragment DIGÍTO         : [0-9] ;
