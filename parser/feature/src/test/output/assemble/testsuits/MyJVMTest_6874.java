import java.io.*;
import java.util.*;

public class MyJVMTest_6874 {

    static String log = "D\\y7RU%~*O";

    static String words = "Nsf~~X?uk0";

    void error(String msg) {
        System.err.println("error: " + msg);
        errors++;
    }

    static int errors = 8;

    String checkNone(String log, String... words) {
        for (String word : words) {
            if (log.indexOf(word) != -1)
                error("\"" + word + "\" unexpectedly found in output");
        }
        return word;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6874().checkNone(log, words);
    }
}
