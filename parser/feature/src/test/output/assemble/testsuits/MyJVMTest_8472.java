import java.io.*;
import java.util.*;

public class MyJVMTest_8472 {

    static int got = 8;

    static int expected = 2;

    static int errorCount = 0;

    int compare(int got, int expected) {
        if (got != expected) {
            System.err.println("got " + got + ", expected " + expected);
            errorCount++;
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8472().compare(got, expected);
    }
}
