package Stack;
import java.util.Stack;

/*
-> delimiter matching is one of the application of stack.
   it is also one of the part of the compiler to check is the brackets are being matched property or not
   if brackets are not in pair compiler throws an error

    Here, we apply the basic implementation of delimiter matching in the string operation using stack
*/

/*
  ---> Algorithm for Delimiter matching
   Start:
   1. read one character at a time say "ch" from input file/string expression
   2. read till the eof(end of file)/end of string expression
   3. while not end of file/string exp
      a. if ch is "(", "{" or "["
         push(ch) push it to the stack
      b. else if ch is ")", "}" or "]"
         stack.pop(); pop the top most element and check with the current character, which is out of one bracket above
      Note: ignore all the character, spaces, symbols, operator beside the opening and closing bracket for delimiter match
           because it is only concerned about the bracket pairs check
   4. at last return true is the stack is empty else return false
   Note: If the stack is empty then it's known that each pair was matched if not the stack will not be empty giving us the false result
   Stop:
*/

public class Delimiter {

//    static method for reading the given string and checking if the bracket pair is defined or not
//    here for simplicity we use the boolean operation false->delimiter didn't match true-> delimiter matched
//    here we use the stack data structure provided by java utils package
    static boolean DelimiterMatch(String expression){
        Stack<Character> stack = new Stack<>(); //definition of character array of stack

        for(char ch : expression.toCharArray()){
            if(ch == '{' || ch == '(' || ch =='['){
                stack.push(ch);
            }else if(ch == ')' || ch =='}' || ch == ']'){
            //pop the element from the stack and check for the current character ch if it matches the pair of bracket or not
                if(stack.isEmpty()) return false;
                char top = stack.pop();
                if(!pair(top, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

//    method for checking the pair of the opening and closing brackets
    static boolean pair(char open, char close){
        return ((open == '(' && close==')') || (open == '[' && close==']') || (open == '{' && close=='}'));
    }

//    main method
    public static void main(String[] args){
        String exp = "[{(})}]"; //this expression is false, extra curly braces not a delimiter
        System.out.println(DelimiterMatch((exp)));
    }
//  Note: you can try using other expression too. Do it by yourself
}
