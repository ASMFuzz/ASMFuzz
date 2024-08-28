import java.io.*;
import java.util.*;

public class MyJVMTest_18060 {

    static int got = 4;

    static int expected = 0;

    static int errorCount = 0;

    int compare(int got, int expected) {
        if (got != expected) {
            System.err.println("got " + got + ", expected " + expected);
            errorCount++;
        }
        return got;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18060().compare(got, expected);
    }
}
