package Stack;

import java.util.Arrays;

//array implementation
/*
    ->In ascending order priority queue the minimum possible element is removed first then the larger value and so on.
*/
public class AscendingPriorityQueue {
    int[] arr;
    int size;

    public AscendingPriorityQueue(){
        this.arr = new int[5];
        this.size = 0;
    }

    public boolean isFull(){
        return size == arr.length;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void enqueue(int val){
        if(isFull()){
            System.out.println("The queue is full");
            return;
        }
        arr[size] = val;
        size++;

        System.out.println(Arrays.toString(arr));
    }

    public void dequeue(){
        if(isEmpty()){
            System.out.println("The queue is empty");
            return;
        }

        int minVal = Integer.MAX_VALUE;
        int index = -1;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < minVal && arr[i] != 0){
                minVal = arr[i];
                index = i;
            }
        }

//        remove the element from the queue
        for(int i = index; i < arr.length - 1; i++){
            arr[i] = arr[i + 1];
        }
        size--;

        System.out.println("dequeued");
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        AscendingPriorityQueue list = new AscendingPriorityQueue();
        list.enqueue(2);
        list.enqueue(4);
        list.enqueue(8);
        list.enqueue(12);
        list.dequeue();
    }
}
