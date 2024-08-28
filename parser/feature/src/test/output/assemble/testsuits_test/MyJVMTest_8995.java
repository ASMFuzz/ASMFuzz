import java.io.*;
import java.util.*;

public class MyJVMTest_8995 {

    static String line = ".g:?$;lqFb";

    static String expect = "}Q%+8!4{D)";

    String verify(String line, String expect) throws Exception {
        if (!line.contains(expect)) {
            System.err.println("line:   " + line);
            System.err.println("expect: " + expect);
            throw new Exception("expected string not found in line");
        }
        return line;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8995().verify(line, expect);
    }
}
