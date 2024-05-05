package Sorting;

import java.util.Arrays;

public class CountSort {
    public static void countSort(int[] arr){
        if(arr == null || arr.length <= 1){
            return;
        }

        int max = largestElem(arr);

        int[] countArray = new int[max + 1];  //frequency array

        for(int num : arr){
            countArray[num]++;  //index is the number itself
        }

        int index = 0; // refering to the array that we replace
        for(int i = 0; i <= max; i++){
            while(countArray[i] > 0){
                arr[index] = i;
                index++;
                countArray[i]--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int largestElem(int[] arr){
        int maxVal = arr[0];
        for(int num : arr){
            if(num > maxVal){
                maxVal = num;
            }
        }

        return maxVal;
    }

    public static void main(String[] args) {
        countSort(new int[]{7,4,5,3,2,6,1});
    }
}
