import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_3188 {

    static int q = 2136372466;

    static int r = 2, c = 0, f = 0, t = 2;

    int start(int q) {
        return q / (50 * 50);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3188().start(q));
    }
}
