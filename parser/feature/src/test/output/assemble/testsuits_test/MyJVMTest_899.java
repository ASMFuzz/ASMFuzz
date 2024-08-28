import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_899 {

    static char c = ',';

    static Random rand = null;

    static int max = 0;

    static int limit = 0;

    static int count = 0;

    static char[] saved = new char[10];

    static int savedCount = 0;

    char push(char c) {
        saved[savedCount++] = c;
        count--;
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_899().push(c);
    }
}
