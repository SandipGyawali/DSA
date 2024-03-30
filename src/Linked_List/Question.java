package Linked_List;

import com.sun.security.jgss.GSSUtil;

import java.util.List;

//merge the given sorted linked list.
public class Question{
        ListNode head;
        ListNode tail;
        static class ListNode {
            int val;
            ListNode next;
            ListNode() {}
            ListNode(int val) { this.val = val; }
            ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }

        public static ListNode reverse(ListNode head){
            ListNode prev, curr, next;
            prev = null;
            curr = next = head;

            while(next != null){
                next = next.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            return prev;
        }

        public static ListNode reverseBetween(ListNode head, int left, int right){
//            here the left and right are the index position not the value
            if(head == null && left == right){
                return head;
            }

            ListNode current = head;
            ListNode prev = null;
            ListNode next = current.next;

            for(int i = 0; i < left - 1; i++){
                prev = current;
                current = current.next;
                next = next.next;
            }

            ListNode last = prev; //for holding the reference value
            ListNode newEnd = current;
            for(int i = 0; i < right - left + 1; i++){
                current.next = prev;
                prev = current;
                current = next;
                if(next != null){
                    next = next.next;
                }
            }

            System.out.println(prev.val);

            return prev;
        }

         static ListNode addTwoNumber(ListNode l1, ListNode l2){
            StringBuilder str1 = new StringBuilder();
            StringBuilder str2 = new StringBuilder();

            while(l1 != null){
                str1.append(l1.val);
                l1 = l1.next;
            }

            while(l2 != null){
                str2.append(l2.val);
                l2 = l2.next;
            }

            str1.reverse();
            str2.reverse();

            int result = Integer.parseInt(str1.toString()) + Integer.parseInt(str2.toString());

            ListNode dummy = new ListNode(0); //dummy
             ListNode temp = dummy;


             while(result  != 0){
                int rem = result % 10;
                result = result / 10;

                ListNode node = new ListNode(rem);

                temp.next = node;
                temp = temp.next;
            }

            return dummy.next;
        }

        static ListNode removeNthFromEnd(ListNode head, int n){
            if(head == null || head.next == null){
                return head;
            }

            head = reverse(head);
            ListNode temp = head;

            for(int i = 1; temp != null && i < n - 1; i++){
                temp = temp.next;
            }

            temp.next = temp.next.next;

            ListNode finalRef = reverse(temp);

            return finalRef;
        }

        public static void main(String[] args){
            ListNode first = new ListNode(1);
            ListNode second = new ListNode(2);
            ListNode third = new ListNode(3);
            ListNode fourth = new ListNode(4);
            ListNode fifth = new ListNode(5);
            first.next = second;
            second.next = third;
            third.next = fourth;
            fourth.next = fifth;

            ListNode temp = removeNthFromEnd(first, 2);
            while(temp != null){
                System.out.print(temp.val + " -> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
}