package Stack;
import java.util.*;

public class CircularQueue {
    private int[] queue;
    private static final int DEFAULT_SIZE = 10;
    int front = 0;  //front pointer to keep track of the starting point of the queue
    int end = 0; //queue pointer pointing towards the end
    int size = 0;

    public CircularQueue(){
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size){
        this.queue = new int[size];
    }

    public boolean isFull(){
//        end may not equal the queue.length because it's circular end and start position changes frequently in circular queue
        return size == queue.length;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        queue[end++] = item;
        end = end % queue.length;
        return true;
    }

    public boolean isEmpty(){
        return end == 0;
    }

    public int remove(){
        if(isEmpty()){
            throw new Error("Cannot remove the element from the empty queue");
        }
        int removed = queue[front++];

        front = front % queue.length;
        size--;

        return removed;
    }

    public int front(){
        if(isEmpty()){
            throw new Error("Queue is empty, cannot get the element");
        }

        return queue[front];
    }

    void display(){
        if (isEmpty()) {
            System.out.println("Empty");
            return;
        }
        int i = front;
        do {
            System.out.print(queue[i] + " -> ");
            i++;
            i %= queue.length;
        } while (i != end);
        System.out.println("END");
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        queue.insert(5);
        queue.insert(10);
        queue.insert(11);
        queue.insert(12);
        queue.insert(20);
        queue.display();
    }
}
