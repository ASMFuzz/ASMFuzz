import java.io.*;
import java.math.*;
import java.nio.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class MyJVMTest_9914 {

    static String testName = "l~!^|F]x+M";

    static boolean failure = false;

    static int failCount = 0;

    static String text = ";}p? .G{\"T";

    static int datalen = 5;

    String report(String testName) {
        System.err.printf("%-30s: %s%n", testName, (failCount == 0) ? "Passed" : String.format("Failed(%d)", failCount));
        if (failCount > 0)
            failure = true;
        failCount = 0;
        return testName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9914().report(testName);
    }
}
