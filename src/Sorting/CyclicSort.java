package Sorting;

import java.util.Arrays;

public class CyclicSort {
    static void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            int index = arr[i] - 1;
            if(arr[i] == arr[index]){
                i++;
            }else{
                swap(arr, i , index);
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args){
        cyclicSort(new int[]{5,3,4,2,1});
    }
}
