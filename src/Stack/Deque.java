package Stack;

import java.util.Arrays;

/*
    #What is Deque?
--> A dequeue (short for "double-ended queue") is a type of data structure that allows for items to be added and removed from
both the front and the back. This flexibility makes deque a highly versatile tool in programming, as they can be used to
implement both stacks and queues with a single data structure.

    Here, we use the circular queue to implement the deque operation
*/
public class Deque {
    private int[] deque;
    private static final int DEFAULT_SIZE = 5;
    private int front;
    private int rear;

    public Deque(){
        this.deque = new int[5];
        front = -1;
        rear  = -1;
    }

    public void enqueueFront(int val){
        if((front == 0 && rear == DEFAULT_SIZE - 1) || front == rear + 1){
            System.out.println("Queue is full");
        }else if(front == -1 && rear == -1){
            front = rear = 0;
            deque[front] = val;
        }else if(front == 0){
            front = DEFAULT_SIZE - 1;
            deque[front] = val;
        }else{
            front--;
            deque[front] = val;
        }
    }

    public void enqueueRear(int val){
        if((front == 0 && rear == DEFAULT_SIZE - 1) || front == rear + 1){
            System.out.println("Queue is full");
        }else if(front == -1 && rear == -1){
            front = rear = 0;
            deque[rear] = val;
        }else if(rear == DEFAULT_SIZE - 1){
            rear = 0;
            deque[rear] = val;
        }else{
            rear++;
            deque[rear] = val;
        }
    }

    public void dequeueFront(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is empty");
        }else if(front == rear){
            front = rear = -1;
        }else if(front == DEFAULT_SIZE - 1){
            front = 0;
        }else{
            front++;
        }
    }

    public void dequeueRear(){
        if(front == -1 && rear == -1){
            System.out.println("Queue is Empty");
        }else if(front == rear){
            front = rear = -1;
        }else if(rear == 0){
            rear = DEFAULT_SIZE - 1;
        }else{
            rear--;
        }
    }

    public void display(){
        if(front == -1){
            System.out.println("Queue is Empty");
            return;
        }

        int i = front;
        do{
            System.out.println(deque[i]);
            i = (i + 1) % DEFAULT_SIZE;
        }while(i <= rear);
    }

    void getFront(){
        System.out.println(deque[front]);
    }

    public static void main(String[] args){
        Deque obj = new Deque();
        obj.enqueueFront(5);
        obj.enqueueRear(10);
        obj.display();
    }
}
