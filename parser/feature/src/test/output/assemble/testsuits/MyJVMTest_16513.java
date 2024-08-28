import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_16513 {

    static java.nio.CharBuffer cb = null;

    int read(java.nio.CharBuffer cb) throws IOException {
        throw new IOException("ThrowingReadable always throws");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16513().read(cb));
    }
}
