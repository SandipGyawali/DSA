package Stack;
import java.util.Stack;

/*
   --> The code mentioned checks if the given string or number that is parsed in string format is palindrome or not using stack
    #What is palindrome?
    -> It is A palindrome is a word, phrase, number, or other sequences of characters that reads the same forward and
       backward, ignoring spaces, punctuation, and capitalization.
*/
/*
    #Algorithm for checking the given string is palindrome.

    Start:
     1.push the first half of the string onto the stack
     2. if the string length is odd then the middle character is not red, so mid++
     3. compare the second half of the given string with the stack by popping each element out
     4. if the current character match the top of the stack then continue else break and return false
*/

public class Palindrome {
    private Stack<Character> stack;

    Palindrome(){
        stack = new Stack<>();
    }

    boolean isPalindrome(String expression){
        int n = expression.length();
        int mid = n / 2;

//        store the first half to the stack
//        if the given string is odd then don't input the middle element to the stack else input to the stack
        for(int i = 0; i < mid; i++){
            stack.push(expression.charAt(i));
        }


//        check if the given string is odd or not
//        if yes then mid++ because we don't compare the middle element when the string is odd
        if(mid % 2 != 0){
            mid++;
        }

//        compare the second half of the array with the stack
        while(mid < n){
            if(stack.isEmpty() || stack.pop() != expression.charAt(mid)){
                return false;
            }
            mid++;
        }

        return true;
    }
}
