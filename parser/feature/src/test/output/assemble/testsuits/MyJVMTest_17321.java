import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_17321 {

    static int q = 7;

    static int r = 3, c = 8, f = 6, t = -1093890775;

    int end(int q) {
        return (q / 50) % 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17321().end(q));
    }
}
