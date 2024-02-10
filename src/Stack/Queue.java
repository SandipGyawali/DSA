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
    int end = 0; //queue pointer pointing towards the end

    public Queue(){
        this(DEFAULT_SIZE);
    }

    public Queue(int size){
        this.queue = new int[size];
    }

    public boolean isFull(){
        return end == queue.length - 1;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        queue[end++] = item;
        return true;
    }

    public int remove(){
        if(isEmpty()){
            throw new Error("Cannot remove the element from the empty queue");
        }
        int removed = queue[0];

//      while removing, remove the first element and then shift all the element by one
//      the above case is the queue without using the front ptr variable.
//      if front and rear ptr variable is defined then shift the pointer by one.
//      Note: don't forget the case of the queue wrapping or index overflow where the queue has the un-used space at the beginning of the array
//      takes O(n) time to remove the element and shift the element to one step forward
        for(int i = 0; i < end; i++){
            queue[i] = queue[i + 1];
        }

//        now the item has been removed the rear pointer should also be decreased.
        end--;
        return removed;
    }

    public int front(){
        if(isEmpty()){
            throw new Error("Queue is empty, cannot get the element");
        }

        return queue[0];
    }

    void display(){
        System.out.println(Arrays.toString(queue));
    }

    public static void main(String[] args){
        Queue queue = new Queue();
        queue.insert(5);
        queue.insert(10);
        queue.remove();
        queue.front();
        queue.display();
    }
}
