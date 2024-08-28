import java.io.*;
import java.util.*;

public class MyJVMTest_8797 {

    static String log = "tQ\"<OE0y+x";

    static String words = "kT~3c7`lK ";

    void error(String msg) {
        System.err.println("error: " + msg);
        errors++;
    }

    static int errors = -974467887;

    String checkNone(String log, String... words) {
        for (String word : words) {
            if (log.indexOf(word) != -1)
                error("\"" + word + "\" unexpectedly found in output");
        }
        return word;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8797().checkNone(log, words);
    }
}
