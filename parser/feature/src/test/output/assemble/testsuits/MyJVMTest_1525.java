import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_1525 {

    static int q = 0;

    int start(int q) {
        return q / (50 * 50);
    }

    int end(int q) {
        return (q / 50) % 50;
    }

    static int r = 7, c = 0, f = 821183249, t = 3;

    boolean stuck(int q) {
        return start(q) == end(q);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1525().stuck(q));
    }
}
