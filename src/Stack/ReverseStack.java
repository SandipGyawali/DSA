package Stack;

import java.util.Stack;

//reverse a stack using recursion
public class ReverseStack {
    //    reverse a stack using recursion using temp stack (can also be done without using the temp stack variable)
    static java.util.Stack<Integer> reverseStack(java.util.Stack<Integer> stack, java.util.Stack<Integer> list){
        if(stack.isEmpty()){
            return list;
        }

        list.push(stack.pop());
        return reverseStack(stack, list);
    }

    static void reverseStackWithoutTemp(java.util.Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int val = stack.pop();
        reverseStackWithoutTemp(stack);

        insertBottom(stack, val);
    }

    //this below method is the part of the reverseStackWithoutTemp variable
    static void insertBottom(java.util.Stack<Integer> stack, int val){
        if(stack.isEmpty()){
            stack.push(val);
            return;
        }

        int temp_val = stack.pop();
        insertBottom(stack, val);
        stack.push(temp_val);
    }

    static void sortStack(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }

        int val = stack.pop();

        sortStack(stack);

        insertOptimum(stack, val);
    }

    private static void insertOptimum(Stack<Integer> stack, int val){
        if(stack.isEmpty() || val > stack.peek()){
            stack.push(val);
            return;
        }

        int temp_val = stack.pop();
        insertOptimum(stack, val);
        stack.push(temp_val);
    }
}
