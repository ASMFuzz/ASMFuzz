import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_6235 {

    static java.nio.CharBuffer cb = null;

    static String text = "&,~v>]*3w<";

    static int datalen = -968500513;

    int read(java.nio.CharBuffer cb) throws IOException {
        throw new IOException("ThrowingReadable always throws");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6235().read(cb));
    }
}
