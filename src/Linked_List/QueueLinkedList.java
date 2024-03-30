package Linked_List;

public class QueueLinkedList {
    Node head; //first reference of the queue
    Node tail; //last reference of the queue

    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    public void enqueue(int val){
        Node node = new Node(val);

        if(head == null && tail == null){
            head = tail = node;
        }else{
            tail.next = node;
            tail = node;
        }
    }

    public void dequeue(){
        if(head == null && tail == null){
            System.out.println("The queue is empty");
        }else{
            head = head.next;
        }
    }

    public void display(){
        Node temp = head;

        if(head == null && tail == null){
            System.out.println("The queue is empty");
        }else{
            while(temp != null){
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
        }
    }

    public boolean isEmpty(){
        return (head == null && tail == null);
    }

    public int peek(){
        if(head == null && tail == null){
            System.out.println("The queue is empty");
            System.exit(1);
        }
        return head.val;
    }

    public static void main(String[] args){
        QueueLinkedList list = new QueueLinkedList();
        list.enqueue(5);
        list.enqueue(8);
        System.out.println(list.peek());
        list.display();
    }
}