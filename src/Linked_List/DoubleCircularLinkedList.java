package Linked_List;

class DoubleCircularLinkedList {
    Node head;
    Node tail;
    int size = 0;

    class Node{
        Node next;
        Node prev;
        int val;

        Node(int val){
            this.val = val;
        }

        Node(int val, Node next, Node prev){
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    void insert(int val){
        Node node = new Node(val);
//        if the linked list is empty
        if(head == null){
            head = tail = node;
            head.next = head;
            head.prev = head;
            size++;
        }else{
            tail.next = node;
            node.prev = tail;
            node.next = head;
            head.prev = tail;
            tail = node;
            size++;
        }
    }

    void insertBegin(int val){
        if(head == null){
            insert(val);
        }else{
            Node node = new Node(val);
            node.next = head;
            tail.next = node;
            node.prev = tail;
            head.prev = node;
            head = node;
            size++;
        }
    }

    void insertLast(int val){
        if(head == null){
            insert(val);
        }else{
            Node node = new Node(val);
            node.prev = tail;
            tail.next = node;
            node.next = head;
            head.prev = node;
            tail = node;
            size++;
        }
    }

    void insertPos(int index, int val){
        if(index == 0) insertBegin(val);
        else if(index == size - 1) insertLast(val);

        Node temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
//        logic for the insertion.
        Node node = new Node(val);
        node.prev = temp;
        node.next = temp.next;
        temp.next.prev = node;
        temp.next = node;
        size++;
    }

    void deleteBegin(){
        if(head == null){
            System.out.println("The list is empty, Cannot delete");
            return;
        }else if(size == 1){
            head = tail = null;
            return;
        }

        head.prev.next = head.next;
        head.next.prev = head.prev;
        head = head.next;
        size--;
    }

    void deleteLast(){
        if(tail == null){
            System.out.println("Cannot delete the list is empty");
            return;
        }else if(size == 1){
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = head;
        head.prev = tail;
        size--;
    }

    void deletePos(int index){
        if(index == 0){
            deleteBegin();
            return;
        }
        Node temp = head;
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        if(temp.next == head){
            tail = temp.prev;
        }
        size--;
    }

    void display(){
        Node temp = head;
        while(temp != tail){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.print(temp.val + " -> ");
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoubleCircularLinkedList list = new DoubleCircularLinkedList();
        list.insert(5);
        list.insert(10);
        list.insert(1);
        list.insertBegin(100);
        list.insertLast(200);
        list.insertPos(1, 2);
        list.display();
        list.deletePos(1);
        list.display();
    }
}
