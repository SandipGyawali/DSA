package Sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,5};
        //selection sort
        selection_Sort(arr);
    }

    static void selection_Sort(int[] nums){
        for(int i = 0; i < nums.length; i++){
            int last = nums.length - 1- i;
            int max_index = max_Value_Index(nums, 0, last);
            swap(nums, max_index, last);
        }
        System.out.println(Arrays.toString(nums));
    }

    static int max_Value_Index(int[] arr, int start, int end){
        int largest_Value = arr[0];
        int index = 0;
        for(int i = start; i <= end; i++){
            if(arr[i] > largest_Value){
                largest_Value = arr[i];
                index = i;
            }
        }
        return index;
    }
    //    method for swap
    static void swap(int[] arr, int max_Index, int last){
        int temp = arr[last];
        arr[last] = arr[max_Index];
        arr[max_Index] = temp;
    }
}
