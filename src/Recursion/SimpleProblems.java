package Recursion;

import com.sun.jdi.IntegerType;

public class SimpleProblems {
//    find the reverse of the given integer and string number
    static String reverseInt(int val){
        if(val <= 0){
            return  "";
        }

        int rem = val % 10;
        return rem + reverseInt(val / 10);
    }

    static String reverseString(String rString, String str){
        if(str.isEmpty()){
            return rString;
        }

        char ch = str.charAt(str.length() - 1);
        rString += ch;

        return reverseString(rString, str.substring(0, str.length() - 1));
    }


    //    find the palindrome of the givne string by using recursion
//    -> to find the palindrome first reverse the string and then compare the reversed string with the original string that's it
    static boolean isPalindrome(String val){
        String reversedVal = reverseString("", val);

        for(int i = 0; i < val.length(); i++){
            if(!(val.charAt(i) == reversedVal.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//      integer space
        int integerReverse = Integer.parseInt(reverseInt(123));  //the returned result is string so typecast to int,
        System.out.printf("The reversed integer number is: %d", integerReverse);
        System.out.println();
//      string space
        String reverseString = reverseString("", "This");
        System.out.println(reverseString);

//        palindrome space
        System.out.println(isPalindrome("abcba"));
    }
}
