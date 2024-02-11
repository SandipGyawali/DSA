package Stack;
import java.util.*;

public class CircularQueue {
    protected int[] queue;
    private static final int DEFAULT_SIZE = 5;
    int end = -1;  //queue pointer pointing to the start and end
    int front = -1;  //you can add or not adding is also ok

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        this.queue = new int[size];
    }

    boolean isFull(){
        return ((end + 1) % DEFAULT_SIZE) == front;
    }

    boolean isEmpty(){
        return front == -1 && end == -1;
    }

    public boolean enqueue(int val) throws ArrayIndexOutOfBoundsException{
//        first queue is full or not condition
        if(isFull()){
            throw new IndexOutOfBoundsException("Queue is full, overflow");
        }else if(isEmpty()){
            front = end = 0;
            queue[end] = val;
        }else{
            end = (end + 1) % DEFAULT_SIZE;
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
            front = (front + 1) % DEFAULT_SIZE;
        }
        return true;
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        int i = front;
        while(i != end){
            System.out.print(queue[i] + " ");
            i = (i + 1) % DEFAULT_SIZE;
        }
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            System.exit(1);
        }
        return queue[front];
    }
}
