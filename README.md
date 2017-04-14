# Recursive-Descent-Interpreter
##
This is a recursive descent interpretter for a boolean grammar,an interpretter needs to do following with any language ,
It has to parse the input for getting the next token and depending the next token it has to perform the action
 NonTerminal - it has to be replaced with appropriate production rule
 Terminal - implement the interpret operation for nonterminal expressions in the language.
This interpretter takes input from the file and should have an expression size of 100 charecters Expressions may
contain white spaces and white spaces should be considered to be delimiters(i.e. a white space between the - and > of the implication symbol would be asyntax error). The interpretter checks if the expression in the file is of validsyntax and (if valid) computes the value of the expression. The output should either be an error message or a a message that gives the value of the expression.

## Execution
  the recursive descent interpretter can be executed by opening the file Syntax.java in any IDE like netbeans which evaluates the expression from the file specified 
To check any file run the file in the IDE 
during the execution it will ask you to enter the path of your file
suppose you have the file test.txt in programs folder on your desktop ,enter its path  c:/users/desktop/prog/test.txt
it will evaluate it to give appropriate message
if your file has string T ,it will evaluate to true 
if it has TvF,it will evaluate to true 
