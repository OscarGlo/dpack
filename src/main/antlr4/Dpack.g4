grammar Dpack;

program: function*;

function: ID LPAR (ID (SEP ID)*)? RPAR block;
block: LCUR statement* RCUR;

// Statements
statement: if_ | incdec | affect | dataSet | setData | tellraw | funCall | COMMAND;

if_: cond block else_if* else_?;
else_if: ELSE cond block;
else_: ELSE block;
cond: (IF | UNLESS) (ENTITY SEL | boolExpr);

affect: var (SET (value | COMMAND) | opSet value);
opSet: ADDSET | SUBSET | MULSET | DIVSET | MODSET | LT | GT | SWAP;

dataSet: entityDataPath SET (valString | entityDataPath | COMMAND);
setData: var SET entityDataPath;
entityDataPath: DATA SEL dataPath;
dataPath: ID (DOT ID | LSQ NUM RSQ)*;

tellraw: (PRINT | TELLRAW) SEL? tellrawPart (SEP tellrawPart)*;
tellrawPart: var | STRING;

funCall: var LPAR (value (SEP value)*)? RPAR;

incdec: var (INC | DEC);

// Values
boolExpr: var (op value)?;
valString: value | STRING;
value: NUM | var;
var: (SEL DOT)? ID;
op: EQ | GTE | GT | LTE | LT;

// Keywords
IF: 'if';
UNLESS: 'unless';
ELSE: 'else';
TELLRAW: 'tellraw';
PRINT: 'print';
ENTITY: 'entity';
DATA: 'data';

// Tokens
NUM: '-'? [0-9]+;
ID: [a-zA-Z0-9_]+;
STRING: '"' (('\\'.) | ~[\\"\r\n])* '"';
SEL: '@' [parse] ('[' ~']'* ']')?;
COMMAND : '/' ~[\r\n]* ('\r'?'\n'|'/');

EQ: '==';
GTE: '>=';
GT: '>';
LTE: '<=';
LT: '<';
INC: '++';
ADDSET: '+=';
DEC: '--';
SUBSET: '-=';
MULSET: '*=';
DIVSET: '/=';
MODSET: '%=';
SWAP: '><';
SET: '=';
SEP: ',';
DOT: '.';
LPAR: '(';
RPAR: ')';
LSQ: '[';
RSQ: ']';
LCUR: '{';
RCUR: '}';

// Ignored
WS: [ \r\n\t]+ -> skip;
LINE_COMMENT : '#' ~[\r\n]* -> skip;