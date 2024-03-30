package Linked_List;

public class CircularLinkedList {
    Node head; //reference of the starting node.
    Node tail; //reference of the ending node.
    int size = 0;

    class Node{
        Node next;
        int val;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node next){
            this.val = val;
            this.next = next;
        }
    }

    void insertFirst(int val){
        Node node = new Node(val);
        if(head == null){
            head = tail = node;
            node.next = head; //circular link
            size++;
            return;
        }
        tail.next = node;
        node.next = head;
        head = node;
        size++;
    }

    void insertLast(int val){
        if(tail == null){
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        node.next = head;
        tail.next = node;
        tail = node;
        size++;
    }

    void insertPos(int val, int index){
        if(index > size - 1 || index < 0){
            System.out.println("Cannot insert at the position");
            System.out.println("The size of the list is: " + size);
            return;
        }

        if(index == 0 || head == null){
            insertFirst(val);
            return;
        }else if(index == size - 1){
            insertLast(val);
        }

        Node temp = head;
        Node node = new Node(val);
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }

    void display(){
        if(head == null){
            System.out.println("The list is empty, cannot print");
            return;
        }
        Node temp = head;
        do{
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }while(temp != head);
        System.out.println("null");
    }

    void deleteFirst(){
        tail.next = head.next;
        head = head.next;
        size--;
    }

    void deleteLast(){
        if(head == null){
            System.out.println("Cannot delete the list is empty");
        }else if(head == tail){
            deleteFirst();
        }else{
            Node temp = head;
            for(int i = 0; i < size - 2; i++){
                temp = temp.next;
            }
            temp.next = head;
            tail = temp;
            size--;
        }
    }

    void deletePos(int index){
        if(index > size - 1 || index < 0 || head == null){
            System.out.println("Cannot delete at the position");
            System.out.println("The size of the list is: " + size);
            return;
        }

        if(index == 0){
            deleteFirst();
            return;
        }else if(index == size - 1){
            deleteLast();
            return;
        }

        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    void reverse(){
        Node prev, curr, next;
        curr = head;
        next = curr.next;
        prev = null;
        while(curr != tail){
            prev = curr;
            curr = next;
            next = curr.next;
            curr.next = prev;
        }
        next.next = tail;
        tail = next;
        head = curr;
    }

    public static void main(String[] args){
        CircularLinkedList list = new CircularLinkedList();
        list.insertFirst(5);
        list.insertLast(6);
        list.insertLast(7);
        list.display();
        System.out.println();
        list.reverse();
        list.display();
    }
}
