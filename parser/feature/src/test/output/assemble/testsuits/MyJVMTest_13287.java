import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_13287 {

    static int depth = 1494858539;

    static int pos = -2067110732;

    static int airOverrideStart = 0;

    static int airOverrideEnd = 6;

    static boolean AIR = true, ROCK = false;

    static int r = 3, c = 1662551791, f = 0, t = 5;

    static boolean[][] grid = {{true,true,false,false,true,true,false,true,true,false},{true,true,false,false,true,true,false,true,true,false}};

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
        System.out.println(new MyJVMTest_13287().calcWalkingRange(depth, pos, airOverrideStart, airOverrideEnd));
    }
}
