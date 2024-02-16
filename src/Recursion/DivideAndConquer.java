package Recursion;

/*
* #What is Recursion??
Ans:
Recursion is a concept in mathematics and computer science where a function calls itself directly or indirectly to solve
a problem. This technique involves breaking down a problem into smaller instances of the same problem until reaching a
base case that can be solved directly. The solution to the base case is then used to solve the original problem.

->In programming, a recursive function typically has two main parts:

Base Case: This is the simplest instance of the problem, which can be solved directly without any further recursion.
The base case acts as a stopping condition to prevent the recursion from continuing indefinitely.

Recursive Case: This is the part of the function where it calls itself with a smaller or simpler subset of the original
problem. The recursive call must always move closer to the base case to ensure that the recursion eventually terminates.

* Example: Find the factorial of a number using recursion?
    public static int fact(int n){
        if(n == 1){
            return 1;
        }
        return n * fact(n - 1);
    }
*/

/*
#What is divide and conquer algorithm??

The divide-and-conquer algorithm is a fundamental algorithmic technique used in computer science for solving a variety of
problems. It operates on the principle of breaking down a problem into smaller, more manageable sub-problems, solving each
of these sub-problems just once, and combining their solutions to solve the original problem. This approach is particularly
effective for problems that can be naturally divided into similar sub-problems.

Divide-and-conquer algorithms typically involve three main steps:

Divide: The original problem is divided into smaller sub-problems that are similar to the original but smaller in size.
This division continues until the sub-problems are small enough to be solved easily and directly, often reaching a base
case where no further division is needed.

Conquer: Each of these sub-problems is solved recursively. If the sub-problems are still too large, the divide step is
applied again to break them down further. Otherwise, the sub-problems are solved directly, usually with a simple method
or by applying a base case solution.

Combine: The solutions to the sub-problems are combined to form a solution to the original problem. The manner of combining
the solutions depends on the problem and the structure of its sub-problems.

Some of the concept that uses divide and conquer approach are:
1. MergeSort
2. QuickSort
3. Binary Search
4. Strassen's Algorithm
*/

public class DivideAndConquer {
//    simple binary search algorithm to find the item from the given array
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,7,8,9};
        System.out.println("The element is at index: " + findElem(arr, 0, arr.length - 1, 20));

        System.out.println("The element is at index: " + findElemNoRecursive(arr, 2));

//        pattern section
        patternPrint(5);
    }

//    below function returns index if the target element is found else -1.
//    Note: the provided array must be in the sorted order either ascending or descending,
    static int findElem(int[] arr, int start, int end, int target){
//        checks for the start and end pointer and if the array element is empty
        if(start == 0 && end == 0 || start > end){
            return -1;
        }

        int mid = start + (end - start) / 2; //this approach prevents the overflow while calculating for the larger value

//        if target found
        if(arr[mid] == target){
            return mid;
        }

//        if greater else shorter
        if(arr[mid] > target){
            return findElem(arr, start, mid - 1, target);
        }
        return findElem(arr, mid + 1, end, target);
    }


//    divide and conquer without using recursion
//    returns the index if the value is found in the given index else returns -1
    static int findElemNoRecursive(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        if(arr.length == 0){
            return -1;
        }


        while(start <= end){
            int mid = start + (end - start) / 2;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[mid] > target){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

/*

 *
 * *
 * * *
 * * * *
 * * * * *

*/
    static void patternPrint(int n) {
        if (n <= 0) {
            return;
        } else {
            patternPrint(n - 1);

//            after that print the number of stars for the given in the horizontal side
            for (int i = 0; i < n; i++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}


