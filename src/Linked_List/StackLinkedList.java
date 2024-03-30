package Linked_List;

// implementation of stack using linked list
public class StackLinkedList{
    Node top;

    static class Node{
        int val;
        Node next;

        Node(int val){
            this.val = val;
        }
    }

    public void push(int val){
        Node node = new Node(val);
        node.next = top;
        top = node;
    }

    public void pop(int val){
        if(!isEmpty()){
            top = top.next;
        }else{
            System.out.println("The stack is empty");
            System.exit(1);
        }
    }

    public void display(){
        Node temp = top;
        while(temp != null){
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
    }

    public boolean isEmpty(){
        return top == null;
    }

    public static void main(String[] args){
        StackLinkedList list = new StackLinkedList();
        list.push(1);
        list.push(2);
        list.display();
        System.out.println(list.isEmpty());
    }
}