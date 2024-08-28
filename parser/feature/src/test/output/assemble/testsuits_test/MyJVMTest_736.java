import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_736 {

    static String testName = "9p47imW<{>";

    static boolean failure = false;

    static int failCount = 0;

    static String text = "0+yHk@|Fr}";

    static int datalen = 1;

    String report(String testName) {
        System.err.printf("%-30s: %s%n", testName, (failCount == 0) ? "Passed" : String.format("Failed(%d)", failCount));
        if (failCount > 0)
            failure = true;
        failCount = 0;
        return testName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_736().report(testName);
    }
}
