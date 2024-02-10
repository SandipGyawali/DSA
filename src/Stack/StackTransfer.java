package Stack;
import java.util.Scanner;
import java.util.Stack;

/*
    #Transfer the elements from the stack S1 to stack S2 so that elements from S2 are in the same order as on S1.
     a. Using one additional stack,
     b. using no additional stack but only some additional non-array variable,
*/

//this code can work with int, character data types
public class StackTransfer<T>{
    private Stack<T> stack;
    private Stack<T> temp_stack; //temporary variable for holding the stack value before transfering
    private Stack<T> stack2; //this variable for stack transfer
    StringBuilder temp = new StringBuilder(); //this method is for the function nonAdditionalTransfer
    private Class<T> type; //class token to identify the type of stack

    StackTransfer(Class<T> type){
//       add the data at the run time
        this.type = type;
        stack = new Stack<>();
        stack2= new Stack<>();
        temp_stack = new Stack<>();

//        add the sample data based on the data type
        if(type == Integer.class){
            for(int i = 0; i < 5; i++){
//                while adding the data to the generic type it must be type casted to the generic type
//                here we convert the type to the generic type T
                stack.push(type.cast(i + 1));
            }
        }else if(type == Character.class){
            for(int i = 0; i < 5; i++){
                stack.push(type.cast((char) ('a' + i)));
            }
        }
    }


//    this method uses the stack to hold the data temporarily and add it to the stack2
    /*
    * first pop from the stack and add it to the temp stack
    * then pop the element from the pop stack and add push is to the stack2 for final transfer
    * */
    void additionalTransfer(){
        System.out.println("Stack: " + stack);
//        load the data to the temp stack
        while(!stack.isEmpty()){
            temp_stack.push(stack.pop());
        }
//        now transfer the element from the temp stack to the stack2
        while(!temp_stack.isEmpty()){
            stack2.push(temp_stack.pop());
        }

//        here we loaded the sample data as 1,2,3,4,5 for int type and a,b,c,d for the character type then the stack should have the value as 5,4,3,2,1
//        System.out.println(stack2.peek());  should contain 5 or e on the top of stack
        System.out.println("After transfer to stack2 using temporary stack variable");
        System.out.println("Stack2: " + stack2);  //should contain the exact value as the stack
    }

//    it uses no stack instead uses the string to hold the data temporarily to transfer
    void nonAdditionalTransfer(){
        System.out.println();
        System.out.println("Stack: " + stack);
//        load the data to the temp stack
        while(!stack.isEmpty()){
            temp.append(stack.pop());
        }
        temp.reverse();  //the data stored will be in descending order while storing temporarily
//        read one character at a time from the string and add it to the destination stack
        for(int i = 0; i < temp.length(); i++){
            stack2.push(convertChar(temp.charAt(i)));
        }

        System.out.println("After transfer to stack2 without using temporary stack");
        System.out.println("Stack2: " + stack2);
    }

    @SuppressWarnings("unchecked")
    private T convertChar(char ch) {
        if (type == Integer.class) {
            if(Character.isDigit(ch)){
                return (T) Integer.valueOf(Character.getNumericValue(ch));
            }else{
                throw new IllegalArgumentException("Character is not a digit:" + ch);
            }
        } else if (type == Character.class) {
            return (T) Character.valueOf(ch);
        }
        throw new IllegalArgumentException("Unsupported type: " + type);
    }

    public static void main(String[] args){
        StackTransfer<Integer> obj = new StackTransfer<>(Integer.class);
//        Note: use the additionalTransfer or nonAdditionalTransfer method don't use both it will not work
//        for that new instance must be created
        obj.additionalTransfer();

        StackTransfer<Character> obj2 = new StackTransfer<>(Character.class);
        obj2.nonAdditionalTransfer();
    }
}
