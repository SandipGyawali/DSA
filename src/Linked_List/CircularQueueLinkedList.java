package Linked_List;

public class CircularQueueLinkedList {
    Node front;
    Node rear;

    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    public void enqueue(int val){
        Node node = new Node(val);

//        if queue is empty
        if(front == null && rear == null){
            front = rear = node;
            rear.next = front;
        }else{
            rear.next = node;
            rear = node;
            rear.next = front;
        }
    }

    public void dequeue(){
        if(front == null && rear == null) {
            System.out.println("The queue is empty cannot dqueue");
        }else if(front == rear){
            front = rear = null;
        }else{
            front = front.next;
            rear.next = front; //rear.next == new front for the cycle queue implementation of linked list
        }
    }

    public void display(){
        Node temp = front;
        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }while(temp != front);
        System.out.println("null");
    }

    public boolean isEmpty(){
        return (front == null && rear == null);
    }

    public static void main(String[] args){
        CircularQueueLinkedList list = new CircularQueueLinkedList();
        list.enqueue(5);
        list.enqueue(4);
        list.enqueue(12);
        list.display();
        list.dequeue();
        list.display();
    }
}
