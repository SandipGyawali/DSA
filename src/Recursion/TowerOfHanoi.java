package Recursion;

/*

Ans: The Tower of Hanoi is a classic mathematical puzzle that involves three pegs (or rods) and a number of disks of different
sizes which can slide onto any peg. The puzzle starts with all the disks neatly stacked in ascending order of size on one peg,
the smallest at the top, making a conical shape. The objective of the puzzle is to move the entire stack to another peg, adhering
to the following rules:

* Only one disk can be moved at a time. Each move consists of taking the upper disk from one of the stacks and placing it on
top of another stack or on an empty peg.

* No disk may be placed on top of a smaller disk. This constraint requires strategic movement of the disks to ensure that each
move is valid according to the rules.

* The minimum number of moves required to solve the puzzle is

-> 2 ^ n - 1,

n is the number of disks. This means that with each additional disk, the complexity of the puzzle increases significantly.

*/

import java.util.Scanner;

public class TowerOfHanoi {

//    non-recursive approach of solving the tower of hanoi problem
    public static void toh(int n, char s, char a, char d){
        if(n > 0){
            toh(n - 1, s , d, a);
            System.out.printf("Moved disk %d from %c to %c", n, s, a);
            System.out.println() ;
            toh(n - 1, a, s, d);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of disk:");
        int val = in.nextInt();
        toh(val, '1', '2', '3');
    }
}
