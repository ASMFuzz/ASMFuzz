import java.io.*;
import java.util.*;
import java.nio.charset.*;
import java.nio.*;

public class MyJVMTest_1958 {

    static byte[] lowBytes = new byte[0xa0];

    static char[] lowChars = new char[0xa0];

    static int passed = 0, failed = 0;

    void pass() {
        passed++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1958().pass();
    }
}
