import java.util.*;
import java.util.zip.*;
import java.io.*;

public class MyJVMTest_15355 {

    static boolean entryReady = true;

    static String testName = "B+x#/),3Mk";

    static ZipFile zipFile = null;

    static Enumeration zipFileEntries = null;

    boolean isValidTestName(String testName) {
        if (!testName.startsWith("j9vm.test.")) {
            return false;
        }
        if (!testName.endsWith("Test")) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15355().isValidTestName(testName));
    }
}
