package Linked_List;


public class LinkList {
    Node head;  //head pointer
    Node tail;  //tail pointer
    int size; //linked list size variable

    class Node{
        int value;
        Node next;

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }

    //insert the node at first in the linked list.
    public void InsertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    //insert the node at the last in the linked list.
    public void InsertLast(int val){
        if(tail == null){
            InsertFirst(val);
        }else{
            Node node = new Node(val);
            tail.next = node;
            tail = node;
            size++;
        }
    }

    //insert at the specific point
    public void InsertPoint(int val, int index){
        if(index == 0){
            InsertFirst(val);
            return;
        }

        if(index == size){
            InsertLast(val);
            return;
        }

        Node temp = head;  //temporary pointer
        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        Node node = new Node(val, temp.next);
        temp.next = node;
        size++;
    }


    //get the reference of the node at the specific index
    public Node get(int index){
        Node node = head;
        for(int i = 0; i < index; i++){
            node = node.next;
        }
        return node;
    }

    //deletion of node at first
    public int deleteFirst(){
        int value = head.value;
        head = head.next;

        size--;
        return value;
    }

    //delete the node at last
    public int deleteLast(){
//        if the size is smaller
        if(size <= 1){
            deleteFirst();
        }
        Node second_Last = get(size - 2);

        int value = tail.value;

        tail = second_Last;
        tail.next = null;

        return value;
    }

    public int deletePoint(int index){
        if(index == 0){
            return deleteFirst();
        }

        if(index == size - 1){
            return deleteLast();
        }

        Node prev = get(index - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }

    public void display(){
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.print("null");
    }

    //reverse a linked-list
    public void reverse(){
        Node prev, curr, next;
        prev = null;
        curr = next = head;

        while(next != null){
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    //    insert at specific position using recursion
//    question in interview
    public void insertPointRec(int val, int index, Node ref){
        if(index == 1){
            Node node = new Node(val, ref.next);
            ref.next = node;
            size++;
            return;
        }
        insertPointRec(val, index - 1, ref.next);
    }

    //    remove the duplicate from the linked list
//    leetcode -> https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/
    public void removeDuplicate(Node head){
        Node temp = head;
        while(temp.next != null){
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
                size--;
            }else{
                temp = temp.next;
            }
            tail = temp;
            tail.next = null;
        }
    }

//    merge the two linked list.
//    same as the merge section of the merge sort algorithm
    public static void mergeLinkedList(LinkList first, LinkList second){
        Node temp1 = first.get(0);
        Node temp2 = second.get(0);
        LinkList obj = new LinkList();

        while(temp1 != null && temp2 != null){
            if(temp1.value <= temp2.value){
                obj.InsertLast(temp1.value);
                temp1 = temp1.next;
            }else{
                obj.InsertLast(temp2.value);
                temp2 = temp2.next;
            }
        }

        while(temp1 != null){
            obj.InsertLast(temp1.value);
            temp1 = temp1.next;
        }

        while(temp2 != null){
            obj.InsertLast(temp2.value);
            temp2 = temp2.next;
        }

        obj.display();
    }

    //main method
    public static void main(String[] args) {
        LinkList obj1 = new LinkList();
        obj1.InsertLast(1);
        obj1.InsertLast(2);
        obj1.InsertLast(3);

        LinkList obj2 = new LinkList();
        obj2.InsertLast(1);
        obj2.InsertLast(3);
        obj2.InsertLast(5);

        mergeLinkedList(obj1, obj2);  //why this is static because we are not dependent on any of the instance
    }
}


//determine the number is happy or not,
//google interview question,