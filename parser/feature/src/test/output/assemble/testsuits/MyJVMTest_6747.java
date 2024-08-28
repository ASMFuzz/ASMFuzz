import java.util.*;
import java.io.*;
import java.util.regex.*;

public class MyJVMTest_6747 {

    static int q = 9;

    static int r = 0, c = 0, f = 0, t = 2;

    int depth(int q) {
        return q % 50;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6747().depth(q));
    }
}
