import java.io.*;
import java.util.*;

public class MyJVMTest_8316 {

    static String errorString = "/cjZjw3z?#";

    static int lineNumber = 1184122741;

    static int column = -2039232020;

    String error(String errorString) {
        throw new RuntimeException(errorString + " at line " + lineNumber + " column " + column);
        return errorString;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8316().error(errorString);
    }
}
