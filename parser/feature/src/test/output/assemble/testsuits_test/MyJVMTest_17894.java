import java.io.*;
import java.util.*;

public class MyJVMTest_17894 {

    static String errorString = "`m$IN(s8Q3";

    static int lineNumber = 163527832;

    static int column = 5;

    String error(String errorString) {
        throw new RuntimeException(errorString + " at line " + lineNumber + " column " + column);
        return errorString;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17894().error(errorString);
    }
}
