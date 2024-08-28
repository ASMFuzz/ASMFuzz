import java.io.*;
import java.util.*;

public class MyJVMTest_16382 {

    static String log = "bZ0^@eq.%r";

    static String words = "QKIWL]%>0y";

    void error(String msg) {
        System.err.println("error: " + msg);
        errors++;
    }

    static int errors = 1859524273;

    String checkNone(String log, String... words) {
        for (String word : words) {
            if (log.indexOf(word) != -1)
                error("\"" + word + "\" unexpectedly found in output");
        }
        return word;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16382().checkNone(log, words);
    }
}
