import java.io.*;
import java.util.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.charset.*;

public class MyJVMTest_10080 {

    static char c = Character.MIN_VALUE;

    static Random rand = null;

    static int max = 8;

    static int limit = 9;

    static int count = 0;

    static char[] saved = new char[10];

    static int savedCount = 0;

    char push(char c) {
        saved[savedCount++] = c;
        count--;
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10080().push(c);
    }
}
