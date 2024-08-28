import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_4339 {

    static int row = 1021346561;

    static int column = 2;

    static boolean AIR = true, ROCK = false;

    static int r = -1370053459, c = 4, f = 666539902, t = 5;

    static boolean[][] grid = {{false,true,false,false,false,true,false,true,true,true},{false,false,false,true,true,false,false,false,false,false}};

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
        System.out.println(new MyJVMTest_4339().fall(row, column));
    }
}
