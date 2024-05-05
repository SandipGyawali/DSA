package Sorting;

import java.util.Arrays;

public class ShellSort {
  public static void main(String[] args) {
    System.out.println("This is the shell sort algorithm");
    shellSort(new int[]{5,3,4,2,7});
  }

  public static void shellSort(int[] arr) {
    int n = arr.length;
    for (int gap = n / 2; gap > 0; gap /= 2) {
      for (int i = gap; i < n; i++) {
        int temp = arr[i];
        int j;
        for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
          arr[j] = arr[j - gap];
        }
        arr[j] = temp;
      }
    }

    System.out.println(Arrays.toString(arr));
  }
}