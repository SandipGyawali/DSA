package Recursion;

import java.util.Arrays;

//merge sort inplace implementation
public class MergeSortInPlace {
    //merge sort array
    static void mergeSort(int[] arr, int start, int end){
        if(end - start == 1){
            return;
        }

        int mid = start + (end - start) / 2;

        mergeSort(arr, start , mid);
        mergeSort(arr, mid, end);

        merge(arr, start, mid, end);
    }

    static void merge(int[] arr, int start, int mid, int end){
        int[] mix = new int[end - start];
        int i = start, j = mid,  k = 0;

        while(i < mid && j < end){
            if(arr[i] < arr[j]){
                mix[k] = arr[i];
                i++;
            }else{
                mix[k] = arr[j];
                j++;
            }
            k++;
        }

//        for the case of not empty
        while(i < mid){
            mix[k] = arr[i];
            i++;
            k++;
        }

        while(j < end){
            mix[k] = arr[j];
            j++;
            k++;
        }

        for(int l = 0; l < mix.length; l++){
            arr[start + l] = mix[l];
        }
    }

    //quick sorting algorithm
    static void quickSort(int[] arr, int low, int high){
        if(low >= high){
            return;
        }
        int start = low;
        int end = high;

        int mid = start + (end - start) / 2;
        int pivot = arr[mid];

        while(start <= end){
            while(arr[start] < pivot){
                start++;
            }

            while(arr[end] > pivot){
                end--;
            }

            if(start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        quickSort(arr, low, end);
        quickSort(arr, start, high);
    }

    static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void main(String[] args){
        int[] arr = {5,3,4,2,1};
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }
}
