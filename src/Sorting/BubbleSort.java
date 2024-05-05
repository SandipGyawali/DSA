package Sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void bubbleSort(int[] arr){
        boolean swap = false;
        for(int i = 0; i < arr.length; i++){
            for(int j = 1; j < arr.length - i; j++){
                if(arr[j - 1] > arr[j]){
                    swap(arr, j - 1, j);
                    swap = true;
                }
            }
            if(swap != true){
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args){
        bubbleSort(new int[]{5,3,4,2,1});
    }
}
