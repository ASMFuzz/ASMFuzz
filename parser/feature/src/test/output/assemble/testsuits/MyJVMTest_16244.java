import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_16244 {

    static int q = -1434731700;

    static int r = 8, c = 0, f = 1, t = 4;

    int depth(int q) {
        return q % 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16244().depth(q));
    }
}
