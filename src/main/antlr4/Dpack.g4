grammar Dpack;

program: function*;

function: ID LPAR (ID (SEP ID)*)? RPAR block;
block: LCUR statement* RCUR;

// Statements
statement: if_ | execute | incdec | affect | dataSet | setData | tellraw | funCall | return | COMMAND;

if_: cond block else_if* else_?;
else_if: ELSE cond block;
else_: ELSE block;
cond: (IF | UNLESS) (ENTITY SEL | boolExpr);

executeKeyword: ALIGN | ANCHORED | AS | AT | FACING | IF | IN | ON | POSITIONED | ROTATED | STORE | SUMMON | UNLESS;
subExec: executeKeyword STRING;
execute: subExec+ block;

affect: var (SET (value | COMMAND) | opSet value);
opSet: ADDSET | SUBSET | MULSET | DIVSET | MODSET | LT | GT | SWAP;

dataSet: entityDataPath SET (valString | entityDataPath | COMMAND);
setData: var SET entityDataPath;
entityDataPath: DATA SEL dataPath;
dataPath: ID (DOT ID | LSQ NUM RSQ)*;

tellraw: (PRINT | TELLRAW) SEL? tellrawPart (SEP tellrawPart)*;
tellrawPart: var | STRING;

funName: var;
funCall: (var (SEP var)* SET)? funName LPAR (value (SEP value)*)? RPAR;
return: RETURN value (SEP value)*;

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
RETURN: 'return';

ALIGN: 'align';
ANCHORED: 'anchored';
AS: 'as';
AT: 'at';
FACING: 'facing';
IN: 'in';
ON: 'on';
POSITIONED: 'positioned';
ROTATED: 'rotated';
STORE: 'store';
SUMMON: 'summon';

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