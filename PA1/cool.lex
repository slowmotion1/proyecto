/*
 *  The scanner definition for COOL.
 */

import java_cup.runtime.Symbol;

%%

%{

/*  Stuff enclosed in %{ %} is copied verbatim to the lexer class
 *  definition, all the extra variables/functions you want to use in the
 *  lexer actions should go here.  Don't remove or modify anything that
 *  was there initially.  */

    // Max size of string constants
    static int MAX_STR_CONST = 1025;

    // For assembling string constants
    StringBuffer string_buf = new StringBuffer();
    String texto = "";

    private int curr_lineno = 1;
    int sub_comment_count = 0;
    Boolean error_null = false;
    int get_curr_lineno() {
	return curr_lineno;
    }

    private AbstractSymbol filename;

    void set_filename(String fname) {
	filename = AbstractTable.stringtable.addString(fname);
    }

    AbstractSymbol curr_filename() {
	return filename;
    }
%}

%init{

/*  Stuff enclosed in %init{ %init} is copied verbatim to the lexer
 *  class constructor, all the extra initialization you want to do should
 *  go here.  Don't remove or modify anything that was there initially. */

    // empty for now
%init}

%eofval{

/*  Stuff enclosed in %eofval{ %eofval} specifies java code that is
 *  executed when end-of-file is reached.  If you use multiple lexical
 *  states and want to do something special if an EOF is encountered in
 *  one of those states, place your code in the switch statement.
 *  Ultimately, you should return the EOF symbol, or your lexer won't
 *  work.  */

      switch(yy_lexical_state) {
          case YYINITIAL:
      	/* nothing special to do in the initial state */
      	     break;
          case COMMENTARIO:
              yybegin(YYINITIAL);
              return new Symbol(TokenConstants.ERROR, "EOF en comentarios");
          case STRINGO:
              yybegin(YYINITIAL);
              return new Symbol(TokenConstants.ERROR, "EOF en string");
      }
    return new Symbol(TokenConstants.EOF);
%eofval}

%class CoolLexer
%cup
%state COMMENTARIO
%state STRINGO
%state STRINGOERR

IF = [i|I][f|F]
THEN = [T|t][h|H][e|E][n|N]
ELSE = [e|E][l|L][S|s][E|e]
FI = [f|F][i|I]

INICIACOMMENT = \(\*
TERMINACOMMENT = \*\)


NL = \n
STRING  = \"
POOL = [p|P][o|O][o|O][L|l]
OBJETO_ID = [a-z][0-9|_|A-z]*
LOOP = [L|l][o|O][o|O][p|P]
TIPO_ID = [A-Z][0-9|_|A-z]*
WHILE = [w|W][h|H][i|I][l|L][e|E]

LET = [L|l][e|E][t|T]
IN = [I|i][n|N]

CLASS = [C|c][l|L][A|a][s|S][S|s]

ESPACIOS = [\r| |\f\|\t]
TRUE = t[r|R][u|U][E|e]
FALSE = f[a|A][l|L][S|s][E|e]
INHERITS = [I|i][n|N][H|h][E|e][r|R][I|i][t|T][S|s]
AT = @
ERRORES = [\_|\[|\]|!|\\|\|]
COMMENT_SOLO = --[^\n]*

CASE = [c|C][a|A][s|S][e|E]
OF = [o|O][F|f]
ESAC = [e|E][s|S][a|A][c|C]

NOT = [n|N][o|O][T|t]
ISVOID = [I|i][S|s][v|V][o|O][I|i][D|d]
NEW = [n|N][e|E][W|w]

NULLCHAR = \x00
TRIPLEN = \\\n
DOBLT = \\t
CUATRT = \\\\n
DOBLN = \\n
DOBLB = \\b
DOBLF = \\f
SLSCH = \\\"
FOURSLSCH = \\\\
%%
<YYINITIAL>{ERRORES}                {return new Symbol(TokenConstants.ERROR, yytext());}
<YYINITIAL>{NL}			                { curr_lineno++; }
<YYINITIAL>{ESPACIOS}			          { /* NO HACER NADA HEHE */ }
<COMMENTARIO>{NL}			              { curr_lineno++; }
<YYINITIAL,COMMENTARIO>{ESPACIOS}		{ /* NO HACER NADA HEHE */ }
<YYINITIAL>{COMMENT_SOLO}			      { /*No hacemos nada*/ }
<YYINITIAL, COMMENTARIO>{INICIACOMMENT}	{sub_comment_count=sub_comment_count+1; yybegin(COMMENTARIO);}
<COMMENTARIO>{TERMINACOMMENT}	      { sub_comment_count=sub_comment_count-1;if (sub_comment_count<1) {
                                        yybegin(YYINITIAL);
                                      }
                                    }

<STRINGOERR>\n|\"                   { yybegin(YYINITIAL); }
<COMMENTARIO,STRINGOERR>.|\r			  { /* NO HACER NADA HEHE */ }
<YYINITIAL>{TERMINACOMMENT}	        { return new Symbol(TokenConstants.ERROR, " Hay un cierre de comentario inesperado en la linea:"+curr_lineno);}

<YYINITIAL>"+"			                { return new Symbol(TokenConstants.PLUS); }
<YYINITIAL>"-"			                { return new Symbol(TokenConstants.MINUS); }
<YYINITIAL>"*"			                { return new Symbol(TokenConstants.MULT); }
<YYINITIAL>"/"			                { return new Symbol(TokenConstants.DIV); }
<YYINITIAL>"~"			                { return new Symbol(TokenConstants.NEG); }
<YYINITIAL>"<"			                { return new Symbol(TokenConstants.LT); }
<YYINITIAL>"<="			                { return new Symbol(TokenConstants.LE); }
<YYINITIAL>"<-"			                { return new Symbol(TokenConstants.ASSIGN); }
<YYINITIAL>"="			                { return new Symbol(TokenConstants.EQ); }
<YYINITIAL>"("			                { return new Symbol(TokenConstants.LPAREN); }
<YYINITIAL>")"			                { return new Symbol(TokenConstants.RPAREN); }
<YYINITIAL>"{"			                { return new Symbol(TokenConstants.LBRACE); }
<YYINITIAL>"}"			                { return new Symbol(TokenConstants.RBRACE); }
<YYINITIAL>";"			                { return new Symbol(TokenConstants.SEMI); }
<YYINITIAL>","			                { return new Symbol(TokenConstants.COMMA); }
<YYINITIAL>":"			                { return new Symbol(TokenConstants.COLON); }
<YYINITIAL>"."			                { return new Symbol(TokenConstants.DOT); }
<YYINITIAL>"@"			                { return new Symbol(TokenConstants.AT); }

<YYINITIAL>{TRUE}			              { return new Symbol(TokenConstants.BOOL_CONST,true); }
<YYINITIAL>{FALSE}			            { return new Symbol(TokenConstants.BOOL_CONST,false); }
<YYINITIAL>{NOT}		              	{ return new Symbol(TokenConstants.NOT); }
<YYINITIAL>{ISVOID}			            { return new Symbol(TokenConstants.ISVOID); }

<YYINITIAL>{IF}			                { return new Symbol(TokenConstants.IF); }
<YYINITIAL>{THEN}			              { return new Symbol(TokenConstants.THEN); }
<YYINITIAL>{ELSE}			              { return new Symbol(TokenConstants.ELSE); }
<YYINITIAL>{FI}			                { return new Symbol(TokenConstants.FI); }

<YYINITIAL>{WHILE}		            	{ return new Symbol(TokenConstants.WHILE); }
<YYINITIAL>{LOOP}			              { return new Symbol(TokenConstants.LOOP); }
<YYINITIAL>{POOL}			              { return new Symbol(TokenConstants.POOL); }

<YYINITIAL>{LET}			              { return new Symbol(TokenConstants.LET); }
<YYINITIAL>{IN}			                { return new Symbol(TokenConstants.IN); }

<YYINITIAL>{CASE}			              { return new Symbol(TokenConstants.CASE); }
<YYINITIAL>{OF}			                { return new Symbol(TokenConstants.OF); }
<YYINITIAL>{ESAC}			              { return new Symbol(TokenConstants.ESAC); }

<YYINITIAL>{NEW}			              { return new Symbol(TokenConstants.NEW); }
<YYINITIAL>{CLASS}			            { return new Symbol(TokenConstants.CLASS); }
<YYINITIAL>{INHERITS}		            { return new Symbol(TokenConstants.INHERITS); }

<YYINITIAL>{TIPO_ID}		            { return new Symbol(TokenConstants.TYPEID, AbstractTable.idtable.addString(yytext())); }
<YYINITIAL>{OBJETO_ID}	           	{ return new Symbol(TokenConstants.OBJECTID, AbstractTable.idtable.addString(yytext())); }

<YYINITIAL>{STRING}                 { yybegin(STRINGO);}
<STRINGO>{STRING}                   { yybegin(YYINITIAL);
                                      texto = string_buf.toString();
                                      string_buf.setLength(0);
                                      if(texto.length() >= MAX_STR_CONST) {
                                        return new Symbol(TokenConstants.ERROR, "String demasiado grande en la linea "+curr_lineno);
                                      } else {
                                        return new Symbol(TokenConstants.STR_CONST,AbstractTable.stringtable.addString(texto));
                                      }
                                    }

                                    
<STRINGO>[^\0\n\"\\]+               { string_buf.append(yytext()); }
<STRINGO>{NULLCHAR}                 { yybegin(STRINGOERR);return new Symbol(TokenConstants.ERROR, "String contiene caracter invalido en la linea:"+curr_lineno); }
<STRINGO>{TRIPLEN}                  { string_buf.append("\n"); }
<STRINGO>{DOBLT}                    { string_buf.append("\t"); }
<STRINGO>{CUATRT}                   { string_buf.append("\\n"); }
<STRINGO>{DOBLN}                    { string_buf.append("\n"); }
<STRINGO>{DOBLB}                    { string_buf.append("\b"); }
<STRINGO>{DOBLF}                    { string_buf.append("\f"); }
<STRINGO>{SLSCH}                    { string_buf.append("\""); }
<STRINGO>{FOURSLSCH}                { string_buf.append("\\"); }
<STRINGO>\\                         { ; }
<STRINGO>{NL}                       { string_buf.setLength(0);
                                      yybegin(YYINITIAL);
                                      return new Symbol(TokenConstants.ERROR, "hubo un error con el string en la linea:"); }

<YYINITIAL>[0-9]+   { return new Symbol(TokenConstants.INT_CONST,AbstractTable.inttable.addString(yytext()));}

<YYINITIAL>"=>"			{ /* Sample lexical rule for "=>" arrow.
                         Further lexical rules should be defined
                         here, after the last %% separator */
                         return new Symbol(TokenConstants.DARROW); }

.                   { return new Symbol(TokenConstants.ERROR, yytext()); }
