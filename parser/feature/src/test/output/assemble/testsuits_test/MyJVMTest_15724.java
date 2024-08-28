import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_15724 {

    static java.nio.CharBuffer target = null;

    static Random generator = new Random();

    static String text = "U1jCZ1]+1)";

    static int datalen = 3;

    static int index = 0;

    int read(java.nio.CharBuffer target) throws IOException {
        if (index > datalen - 1)
            return -1;
        int len = target.remaining();
        if (len > 4)
            len = generator.nextInt(3) + 1;
        while ((index + len) > datalen) len--;
        for (int i = 0; i < len; i++) target.put(text.charAt(index++));
        return len;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15724().read(target));
    }
}
