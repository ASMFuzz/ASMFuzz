import java.io.*;
import java.util.*;

public class MyJVMTest_12973 {

    static String line = "C[*gwG?&?f";

    static String expect = "0zM&C?#_h[";

    String verify(String line, String expect) throws Exception {
        if (!line.contains(expect)) {
            System.err.println("line:   " + line);
            System.err.println("expect: " + expect);
            throw new Exception("expected string not found in line");
        }
        return line;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12973().verify(line, expect);
    }
}
