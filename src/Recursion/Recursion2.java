package Recursion;

import java.util.ArrayList;

//some basis question using recursion
public class Recursion2 {
    //array recursion
    //sorted array or not
    static boolean sorted(int[] arr, int index){
        if(index == arr.length - 1){
            return true;
        }

        if(arr[index] < arr[index + 1]) return sorted(arr, index + 1);

        return false;
    }

    //linear search using recursion
    static int linearSearch(int[] arr, int index,int target){
        if(index == arr.length){
            return -1;
        }

        if(arr[index] == target){
            return index;
        }

        return linearSearch(arr, index + 1, target);
    }

    //linear search for multiple occurance
    static ArrayList<Integer> multipleLinear(int[] arr, int index, int target){
        ArrayList<Integer> list = new ArrayList<>();
        if(index == arr.length){
            return list;
        }

        if(arr[index] == target){
            list.add(index);
        }


        ArrayList<Integer> result = multipleLinear(arr, index + 1, target);

        list.addAll(result);
        return list;
    }

    //    rotated binary search using recursion
    static int rotatedBinarySearch(int[] arr, int start, int end, int target){
//        here the value does not exists
        if(start > end){
            return -1;
        }

//        finding the mid between the start and the end pointer
        int mid = start + (end - start) / 2; //finding the mid of the given value

//        get the middle value and then return if the mid value matches the target value
        if(arr[mid] == target){
            return mid;
        }

        if(arr[start] <= arr[mid]) {
            if (arr[start] <= target && arr[mid] >= target) {
                return rotatedBinarySearch(arr, start, mid - 1, target);
            } else {
                return rotatedBinarySearch(arr, mid + 1, end, target);
            }
        }

        if(target >= arr[mid] && target <= arr[end]){
            return rotatedBinarySearch(arr, mid + 1, end, target);
        }
        return rotatedBinarySearch(arr, start, mid - 1, target);
    }
}
