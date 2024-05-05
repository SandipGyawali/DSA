package Recursion;

import java.util.ArrayList;

//subset problems solved using recursion
public class SubSet {
    //subset and string problem
    static String skipChar(String p,String up, char ch){
        if(up.isEmpty()){
            return p;
        }

        char tempCh = up.charAt(0);
        if(up.startsWith("ap") && !up.startsWith("apple")){
            return skipChar(p, up.substring(2), ch);
        }
        p += tempCh;
        return skipChar(p, up.substring(1), ch);
    }

    //subset problem
    //string
    static ArrayList<String> subset(String p, String up){
        ArrayList<String> list = new ArrayList<>();
        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);
        list.addAll(subset(p + ch, up.substring(1)));
        list.addAll(subset(p, up.substring(1)));
        return list;
    }

    //subSet iteration problem
    static void subSetIteration(int[] arr){
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();

        outer.add(new ArrayList<>());  //insert the empty arraylist to the 0th index of the outer arraylist.
        for(int i = 0; i < arr.length; i++){
            int n  = outer.size();
            for(int j = 0; j < n; j++){
                ArrayList<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
    }

    //subset for the duplicate elements
    static void subSetIterationDub(int[] arr){
        int start = 0; //start and end pointer to point to the location for no duplication
        int end = 0;

        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());  //insert the empty arraylist to the 0th index of the outer arraylist.

        for(int i = 0; i < arr.length; i++){
            int n  = outer.size();
            if(i > 0 && arr[i] == arr[i - 1]){
                start = end + 1;
            }

            end = outer.size() - 1; //end will be updated ever time the iteration value is updated by 1

            for(int j = start; j < n; j++){
                ArrayList<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(arr[i]);
                outer.add(inner);
            }
        }
        System.out.println(outer);
    }

    //permutation of a given string
    static ArrayList<String> permutation(String p, String up){
        ArrayList<String> list = new ArrayList<>();

        if(up.isEmpty()){
            list.add(p);
            return list;
        }

        char ch = up.charAt(0);

        for(int i = 0; i <= p.length(); i++){
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            ArrayList<String> result = permutation(f + ch + s, up.substring(1));
            list.addAll(result);
        }

        return list;
    }

    public static void main(String[] args){
        System.out.println(permutation("", "abc"));
    }
}
