package Stack;
import java.util.*;

/*
* A queue is a linear data structure that follows a particular order in which the operations are performed. The order is
* First In First Out (FIFO). This means that the first element added to the queue will be the first one to be removed.
* It is an abstract data type with a predefined capacity. It primarily supports two fundamental operations:

  enqueue: Adds an item to the end of the queue.
  dequeue: Removes an item from the front of the queue.
* */
/*
  #Queue as ADT?
   1. MakeEmpty(q): To make q as an empty queue
   2. IsEmpty(q): To check whether the queue q is full or not. Return true if q is empty, return false otherwise
   3. IsFull(q): To check whether the queue q is full or not. Return true if q is full, return false otherwise
   4. Enqueue(q, x): To insert an item x at the rear of the queue, if and only if q is not full
   5. Dequeue(q): To delete an item from the front of the queue, if and only if the q is not empty
   6. Traverse(q): To read entire queue that display's the content of the queue.
*/


public class Queue {
    protected int[] queue;
    private static final int DEFAULT_SIZE = 10;
    int end = -1;  //queue pointer pointing to the start and end
    int front = -1;  //you can add or not adding is also ok

    public Queue(){
        this(DEFAULT_SIZE);
    }

    public Queue(int size){
        this.queue = new int[size];
    }

    boolean isFull(){
        return end == queue.length - 1;
    }

    boolean isEmpty(){
        return front == -1 && end == -1;
    }

    public boolean enqueue(int val) throws IndexOutOfBoundsException{
        if(isFull()){
            throw new IndexOutOfBoundsException("Queue is full, overflow");
        }else if(front == -1 && end == -1){
            front = end = 0;
            queue[end] = val;
        }else{
            end++;
            queue[end] = val;
        }
        return true;
    }

    public boolean dequeue() throws ArrayIndexOutOfBoundsException{
        if(isEmpty()){
            throw new ArrayIndexOutOfBoundsException("Queue is empty, underflow");
        }else if(front == end){
            front = end = -1;
        }else{
            front++;
        }
        return true;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        for(int i = front; i <= end; i++){
            System.out.print(queue[i] + " ");
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            System.exit(1);
        }
        return queue[front];
    }

    public static void main(String[] args){
        Queue queue = new Queue();
        queue.enqueue(5);
        queue.enqueue(10);
        queue.dequeue();
        queue.display();
    }
}
