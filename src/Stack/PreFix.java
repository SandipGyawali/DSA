package Stack;
import java.util.Stack;

/*
--->A prefix expression, is a mathematical notation in which every
    operator  precedes its operands. It has the advantage of eliminating the need for parentheses that are required
    by infix notation. In postfix notation, the operator is placed after their operands.

    Example of PreFix expression:
        -> 3 + 4 => + 3 4 (infix to postfix)
        -> 3 + 4 * 5 => + 3 * 4 5 (infix to prefix expression)
    rest check out on chatGpt

    GoldenRuleOfThumb: Postfix and prefix operation are used to evaluate the expression in one single scan,
    where infix requires multiple scan which is inefficient
*/

/*
  # Evaluation of a given postfix expression
 -->Start:
     Note: Scan the symbol from the given prefix expression from right to left and for each symbol do the following,
      1. if symbol is an operand
         push it to the stack
      2. if symbol is an operator
         a. pop two symbols out of the stack and apply the operator to evaluate on these symbols
         b. push the result onto the stack
      3. after scanning all the symbols for the postfix expression pop the remaining symbol out of the stack
         and print it on the screen. The remaining symbol is the result obtained after evaluating the postfix expression
 -->Stop:
*/

//not completed
/*
   # Algorithm to convert the given infix expression to the prefix expression
  -->Start:
      Note: first reverse the given infix expression,
      Note: Scan the symbols from the expression from left to right and for each symbol, do the following:
       1.if a symbol is an operand
         print that symbol to the screen/push it to the postfix stack
       2.if a symbol is a right parenthesis
         push it to the stack
       3. if the symbol is the left parenthesis
         pop all the element from the stack and print the values/push it to the postfix stack
         Note: ignore/discard the parenthesis
       4.if a symbol is an operator
         a. if the precedence of the current operator is higher than the top of stack then push the current operator to the stack
         b. else precedence of the current operator is lower then the top of stack pop the element from the stack and print/push to the postfix stack
   -->Stop:
*/

public class PreFix {
    Stack<Character> stack = new Stack<>(); //for normal execution
    Stack<Character> prefix = new Stack<>(); //for postfix expression

    //    conversion of given infix expression to the equivalent prefix expression
    void InfixToPreFix(String exp){
        for(char ch : exp.toCharArray()){
            switch (ch){
                case ')':
                    stack.push(ch);
                    break;
                case '(':
                    char c;
                    while((c = stack.pop()) != ')'){
                        prefix.push(c);
                    }
                    break;
                case '+':
                case '-':
                case '/':
                case '^':
                case '*':
                    //check the precedence of the given character operator with the top of stack
                    while(!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)){
                        prefix.push(stack.pop());
                    }
                    stack.push(ch);
                    break;
                default:
                    prefix.push(ch);
            }
        }

        //there might be the case where the stack is not empty but the loop for the expression is end so for that
        while(!stack.isEmpty()){
            prefix.push(stack.pop());
        }

        //print the postfix stack one by one then reverse it which is the required postfix expression
        StringBuilder str = new StringBuilder();
        while(!prefix.isEmpty()){
            str.append(prefix.pop());
        }

        //print the result
        System.out.println(str);
//        Note: answer should contain 7 5 + 2 * for infix operation (7 + 5) * 2
    }

    //    check the precedence of the given operators
    int precedence(char ch){
        switch (ch){
            case '^':
                return 4;
            case '/':
            case '*':
                return 3;
            case '+':
            case '-':
                return 2;
            default:
                return 1;
        }
    }


    //    evaluation of prefix expression
    static void evaluatePreFix(String exp){
        Stack<Integer> stack = new Stack<>();
        for(int i = exp.length() - 1; i >= 0; i--){
            char ch = exp.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^'){
//                -0 typecast the given number to it's integer number only
                int val1 = stack.pop();
                int val2 = stack.pop();
                int result = operation(ch, val2, val1);
                stack.push(result);
            }else{
                int value = ch - '0';
                stack.push(value);  //stores the result of char type in int type
            }
        }
        //after finishing the evaluation the stack contains only one value which is the answer
        System.out.println(stack.pop());
    }

    //    method that evaluates the results of the two operands using the specific operator
    static int operation(char op, int val1, int val2){
        switch (op){
            case '+':
                return val1 + val2;
            case '-':
                return val1 - val2;
            case '*':
                return val1 * val2;
            case '/':
                if(val2 != 0){
                    return val1 / val2;
                }
                throw new Error("Cannot divide by zero. Invalid Expression");
            case '^':
                return (int) Math.pow(val1, val2);
            default:
                throw new Error("Unsupported operator");
        }
    }
    //    main method
    public static void main(String[] args){
//        for evaluating the given prefix expresssion
        String expression = "++5*236";  //result of the given postfix expression is: 17
        evaluatePreFix(expression);

//        for converting the given infix expression to prefix
        StringBuilder infix = new  StringBuilder("((5*38)+7)+(2-(4/6))"); //infix expression
//       the infix expression should have the prefix expression of ++*5387-2/46
        infix.reverse();
        PreFix obj = new PreFix();
        obj.InfixToPreFix(new String(infix)); //sends the reversed string to the method
    }
}