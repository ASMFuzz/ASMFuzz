import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_10744 {

    static int q = 0;

    int start(int q) {
        return q / (50 * 50);
    }

    int end(int q) {
        return (q / 50) % 50;
    }

    static int r = 5, c = 9, f = 716493391, t = 0;

    boolean stuck(int q) {
        return start(q) == end(q);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10744().stuck(q));
    }
}
