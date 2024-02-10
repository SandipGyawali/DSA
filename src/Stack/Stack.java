package Stack;
import java.util.*;

//basic implementation of stack data structure
/*
What is stack?
-> Stack is a linear data structure in which an element may be inserted or deleted
only at one end call the top end of the stack .i.e the elements are removed from a stack in reverse order of that
in which they were inserted into the stack.
Note: Stack follows the LIFO(Last In First Out) order

Stack can be implemented in two ways
1. Array Implementation
2. LinkedList Implementation
* */


//stack as an ADT
/*
* Create Empty Stack(S): Create or make stack S be an empty stack
* Push(S,x): Insert x at one end of the stack, called it's top
* Top(S): if Stack S is not empty, then retrive the element at it's top
* Pop(S): If stack S is not empty; then delete the element at its top
* IsFull(S): determine whether stack S is full or not. Return true if S is full; else return false
* IsEmpty(S): determine whether stack S is empty or not. Return true if S is an empty stack; else return false
* */


//Array Implementation of Stack
public class Stack {
//    declaration of stack and top variable
    protected int[] stack; //reference to array
    private int top;  //top variable definition

//    defines the instance of the private variable duding run time.
    Stack(){
        stack = new int[5];  //definition of stack with size 5
        top = -1; //initially stack is empty so top variable is set to 1
    }

//    checks if stack is Empty or not.
    public boolean isEmpty(){
        return top == -1;
    }

//    checks if the stack is full or not, .i.e checks if the element can be inserted into the stack or not
    public boolean isFull(){
        return top == stack.length - 1;
    }

//    gets the top value
//    if the stack is not empty then return the value else
    int top(){
        if(isEmpty()) System.exit(1);
        return stack[top];
    }

//    push the provided int value into the stack
    void push(int val){
//        checks if the stack is full or not if not then print Stack overflow
        if(isFull()){
            System.out.println("Stack OverFlow");
            return;
        }
        top++;
        stack[top] = val;
    }
//    pop the element from the stack and return
    int pop(){
        if(isEmpty()){
            System.out.println("Stack underflow");
            System.exit(1);
        }
        int val = stack[top];
        top--;
        return val;
    }

//    extra not required
//    displays the stack in horizontal format right most part being the top exclude the zero
//    array defaults to zero in place of java so don't get confuse there
    void display(){
        System.out.println(Arrays.toString(stack));
    }

//    main method where initially the java program start
    public static void main(String[] args){
//      creating an instance of stack
        Stack stack = new Stack();

        //checks if stack is empty or not, should return false
        System.out.println(stack.isEmpty());
        stack.push(5); //added the value to the stack if not full else terminate the program
        //checks the stack is full or not if yes then return yes otherwise false
        System.out.println(stack.isFull());
        stack.push(8);
        //pops the top element from the stack if not empty, here should return 8 because top contains the value 8
        System.out.println(stack.pop());
        stack.display();  //should print the stack array implementation
    }
//    Note: While implementation check if the underflow and overflow are displayed properly or not. Here in case it's working fine
}
