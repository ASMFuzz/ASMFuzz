import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_928 {

    static String text = "9t`= T!0P0";

    static int datalen = 0;

    void example3() throws Exception {
        Scanner s = new Scanner("1 fish 2 fish red fish blue fish");
        s.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
        for (int i = 1; i <= s.match().groupCount(); i++) System.out.println(s.match().group(i));
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_928().example3();
    }
}
