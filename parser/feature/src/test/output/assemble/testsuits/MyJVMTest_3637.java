import java.io.*;
import java.util.*;

public class MyJVMTest_3637 {

    static String line = "CIi.NA/UR-";

    static String expect = "|9IrLqdUrz";

    String verify(String line, String expect) throws Exception {
        if (!line.contains(expect)) {
            System.err.println("line:   " + line);
            System.err.println("expect: " + expect);
            throw new Exception("expected string not found in line");
        }
        return line;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3637().verify(line, expect);
    }
}
