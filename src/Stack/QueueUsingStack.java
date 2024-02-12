package Stack;
import java.util.Stack;

/*
*
Implementing a queue using stacks is a common computer science problem. It demonstrates how two different data structures
can be combined to fulfill the requirements of a third. A queue is a First In, First Out (FIFO) structure, whereas a
stack is a Last In, First Out (LIFO) structure. To implement a queue using stacks, you need two stacks. The basic idea is
to use one stack for enqueuing (inserting elements) and another for dequeuing (removing elements).

Note: We should use two stack to implement queue
 The code that we implement is not a recursive approach
 * */

public class QueueUsingStack{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    QueueUsingStack(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(int item){
        stack1.add(item);
    }

    public int dequeue(){
        if(isEmpty()){
            throw new Error("The stack is empty, stack underflow");
        }

        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }
    public static void main(String[] args){
        QueueUsingStack queue = new QueueUsingStack();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.dequeue());  //expected output is 1
        System.out.println(queue.dequeue());  //expected output is 2

        queue.enqueue(4);

        System.out.println(queue.dequeue());  //expected output is 3
        System.out.println(queue.dequeue());  //expected output is 4

        System.out.println(queue.dequeue());  //here the queue is empty so error should occur
    }
}
