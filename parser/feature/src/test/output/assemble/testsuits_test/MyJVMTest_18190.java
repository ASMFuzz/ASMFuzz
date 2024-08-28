import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_18190 {

    static String text = "=qM=yt$K9n";

    static int datalen = 63896896;

    void example2() throws Exception {
        Scanner s = new Scanner("1 fish 2 fish red fish blue fish");
        s.useDelimiter("\\s*fish\\s*");
        System.out.println(s.nextInt());
        System.out.println(s.nextInt());
        System.out.println(s.next());
        System.out.println(s.next());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18190().example2();
    }
}
