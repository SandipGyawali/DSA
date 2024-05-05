package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

//some maize question solved using recursion
public class Maize {
    //    backtracking
    //    find the possible path in the maize of 3 * 3 matrix using recursion
    static ArrayList<String> maizePath(int row, int col, String p){
        ArrayList<String> list = new ArrayList<>();
        if(row == 1 && col == 1){
            list.add(p);
            return list;
        }

        if(row > 1){
            list.addAll(maizePath(row - 1, col, p + "D"));
        }

        if(col > 1){
            list.addAll(maizePath(row, col - 1, p + "R"));
        }

        return list;
    }

    //    consider the diagonal as well
    static ArrayList<String> maizePathD(int row, int col, String p){
        ArrayList<String> list = new ArrayList<>();
        if(row == 1 && col == 1){
            list.add(p);
            return list;
        }

        if(row == 2 && col == 2){
            return list;
        }

        if(row > 1){
            list.addAll(maizePathD(row - 1, col, p + "D"));
        }

        if(col > 1){
            list.addAll(maizePathD(row, col - 1, p + "R"));
        }

        if(row > 1 && col > 1){
            list.addAll(maizePathD(row - 1, col - 1, p + "V"));
        }

        return list;
    }

    //    maize with obstacle
    static ArrayList<String> maizePathObstacle(boolean[][] maze, int row, int col,String p){
        ArrayList<String> list = new ArrayList<>();
        if(row == maze.length - 1 && col == maze[0].length - 1){
            list.add(p);
            return list;
        }

        if(!maze[row][col]){
            return list;
        }

        if(row < maze.length - 1){
            list.addAll(maizePathObstacle(maze,row + 1, col, p + "D"));
        }

        if(col < maze[0].length - 1){
            list.addAll(maizePathObstacle(maze ,row, col + 1, p + "R"));
        }

        return list;
    }

    //    maize with all the direction path intro to backtracking
    static void maizePathAll(boolean[][] maze, int row, int col, int[][] matrix, int count){
        if(row == maze.length - 1 && col == maze[0].length - 1){
            matrix[row][col] = count;
            for(int[] num : matrix){
                System.out.println(Arrays.toString(num));
            }
            System.out.println();
            return;
        }

        if(!maze[row][col]){
            return;
        }

        maze[row][col] = false; //mark as false as the recursion call is happening
        matrix[row][col] = count;

        if(row < maze.length - 1){
            maizePathAll(maze,row + 1, col, matrix, count + 1);
        }

        if(col < maze[0].length - 1){
            maizePathAll(maze ,row, col + 1, matrix, count + 1);
        }

        if(row > 0){
            maizePathAll(maze, row - 1, col, matrix, count + 1);
        }

        if(col > 0){
            maizePathAll(maze, row, col - 1, matrix, count + 1);
        }

        maze[row][col] = true; //revert the changes when returning from the recursion call
        matrix[row][col] = 0;
    }

}
