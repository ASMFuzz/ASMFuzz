import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_3940 {

    static int depth = 9;

    static int pos = 9;

    static int airOverrideStart = 0;

    static int airOverrideEnd = 0;

    static boolean AIR = true, ROCK = false;

    static int r = -1495786065, c = 0, f = 0, t = 0;

    static boolean[][] grid = {{false,true,true,true,false,true,false,true,false,false},{true,false,true,true,true,true,true,false,false,true}};

    int calcWalkingRange(int depth, int pos, int airOverrideStart, int airOverrideEnd) {
        int left = pos, right = pos;
        if (depth >= r)
            return (c - 1) * 50 + depth;
        while (left > 0) {
            if (grid[depth][left - 1] == ROCK && (left - 1 < airOverrideStart || left - 1 > airOverrideEnd))
                break;
            if (depth < r - 1 && grid[depth + 1][left - 1] == AIR) {
                left--;
                break;
            }
            left--;
        }
        while (right < c - 1) {
            if (grid[depth][right + 1] == ROCK && (right + 1 < airOverrideStart || right + 1 > airOverrideEnd))
                break;
            if (depth < r - 1 && grid[depth + 1][right + 1] == AIR) {
                right++;
                break;
            }
            right++;
        }
        return left * 50 * 50 + right * 50 + depth;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3940().calcWalkingRange(depth, pos, airOverrideStart, airOverrideEnd));
    }
}
