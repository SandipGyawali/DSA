package Sorting;

import java.util.Arrays;

public class SelectionSort_Rec {
    public static void main(String[] args) {
        int[] arr = {1,3,2,4,5};
        selectionSort(arr);
    }

    static void selectionSort(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int index = arr.length - 1 - i;
            int largest_index  = find_maxIndex(arr, 0, index, 0);
            swap(arr, largest_index, index);
        }

        System.out.println(Arrays.toString(arr));
    }

    //find maximum index for the give array
    static int find_maxIndex(int[] arr, int largest, int index, int find_Index){
        if(index == 0){
            return find_Index;
        }
        if(arr[index] > largest){
            largest = arr[index];
            find_Index = index;
        }
        return find_maxIndex(arr, largest, index - 1, find_Index);
    }

    static void swap(int[] arr, int lrg_Ind_Val, int large){
        int temp = arr[large];
        arr[large] = arr[lrg_Ind_Val];
        arr[lrg_Ind_Val] = temp;
    }
}