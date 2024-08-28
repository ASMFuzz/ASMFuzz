import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_13713 {

    static int row = 0;

    static int column = 4;

    static boolean AIR = true, ROCK = false;

    static int r = 4, c = 8, f = 780386932, t = 1694067623;

    static boolean[][] grid = {{true,true,false,false,false,true,false,true,true,true},{false,false,false,false,true,true,true,true,false,false}};

    int fall(int row, int column) {
        int res = 0;
        for (int p = row + 1; p < r; p++) {
            if (grid[p][column] == AIR)
                res++;
            else
                break;
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13713().fall(row, column));
    }
}
