package Stack;
import java.util.*;
//this class uses the original stack.java file to extend and make a dynamic stack
public class DynamicStack extends Stack{
    public DynamicStack(){
        super();
    }

    @Override
    void push(int val){
        if(this.isFull()){
            int[] temp = new int[stack.length * 2]; //increase the size of the given stack by the size of two time the previous
//            copy all the previous stack item in the new data
            for(int i = 0; i < stack.length; i++){
                temp[i] = stack[i];
            }
//          change the reference of the given stack to the new array stack with double the size of the previous one
            stack = temp;
        }

//        at this point we know that the stack is not full so push the value
        super.push(val);
    }

    public static void main(String[] args) {
        DynamicStack dStack = new DynamicStack();
//        initial limit of the stack that was defined is 5
        dStack.push(1);
        dStack.push(2);
        dStack.push(3);
        dStack.push(4);
        dStack.push(5);
//        here up to the above push the stack is full, but it should create a new size dynamically and add the element to the stack
        dStack.push(6);

        System.out.println(Arrays.toString(dStack.stack)); //working properly
    }
}
