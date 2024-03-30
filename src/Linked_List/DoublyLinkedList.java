package Linked_List;

public class DoublyLinkedList {
    Node head; //head reference
    Node tail; //tail reference
    int size; //to count the size of the linked list

    class Node{
        Node prev;
        Node next;
        int val;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node prev, Node next){
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    void insertDFirst(int val){
        Node node = new Node(val);
        node.next = head;
        if(tail == null){
            tail = head;
        }

        if(head != null){
            head.prev = node;
        }
        head = node;
        node.prev = null;
        size++;
    }

    void insertDLast(int val){
        if(tail == null){
            insertDFirst(val);
        }else{
            Node node = new Node(val);
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
            size++;
        }
    }

    void insertDPoint(int index, int val){
        if(index == 0){
            insertDFirst(val);
            return;
        }

        if(index == size - 1){
            insertDLast(val);
            return;
        }

        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next.prev = node;
        node.prev = temp;
        temp.next = node;
        size++;
    }

    void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    void displayReverse(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    void deleteDFirst(){
        if(head != null){
//            if there is single element
            if(head.next == null){
                head = null;
            }else {
                head.next.prev = null;
                head = head.next;
                size--;
            }
        }else{
            System.out.println("Cannot delete the list is empty");
        }
    }

    void deleteDLast() {
        if (tail != null) {
            // Check if the list has only one element
            if (tail.prev == null) {
                // If there's only one element, then both head and tail should be set to null
                tail = null;
                head = null;
            } else {
                tail = tail.prev;
                tail.next = null;
                size--;
            }
        } else {
            System.out.println("Cannot delete. The list is empty.");
        }
    }

    void deleteDPos(int index){
        if(index == 0){
            deleteDFirst();
            return;
        }
        if(index == size - 1){
            deleteDLast();
            return;
        }

        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        if(temp.prev != null){
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
            size--;
        }
    }

    public static void main(String[] args){
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.insertDFirst(5);
        linkedList.insertDFirst(6);
        linkedList.insertDLast(10);
        linkedList.insertDPoint(1, 100);
        linkedList.display();
        linkedList.deleteDPos(1);
        linkedList.display();
    }
}
