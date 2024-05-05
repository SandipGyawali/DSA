package Recursion;

//contains some basic question on recursion
public class Recursion1 {
    //    print the number from n to 1
    static void print(int val){
        if(val == 0){
            return;
        }
        System.out.print(val + " ");
        print(val - 1);
    }

    static int product(int val){
        if(val == 0){
            return 0;
        }

        int result = val + product(val - 1);
        return result;
    }

    //    find the sum of digits
    static int sumOfDigits(int val){
        if(val == 0){
            return 1;
        }

        int rem = val % 10;
        return rem * sumOfDigits(val / 10);
    }

    // reverse a number using recursion
    static String reverseNum(String s_val, int val){
        if(val == 0){
            return s_val;
        }
        int rem = val % 10;
        s_val += rem;
        return reverseNum(s_val, val / 10);
    }

    //check for the number to be palindrome or not using recursion
    static boolean palindrome(String str, int start, int end){
        if(start >= end){
            return true;
        }

        if(str.charAt(start) != str.charAt(end)) return false;

        return palindrome(str, start + 1, end - 1);
    }

    //count number of zero in the int value using recusion
    static int zeroCount(int val, int count){
        if(val == 0){
            return count;
        }

        int rem = val % 10;

        if(rem == 0){
            count++;
        }

        return zeroCount(val / 10, count);
    }

    static int numberOfSteps(int val, int count){
        if(val == 0){
            return count;
        }

        if(val % 2 == 0){
            return numberOfSteps(val / 2, count + 1);
        }

        return numberOfSteps(val - 1, count + 1);
    }
}
