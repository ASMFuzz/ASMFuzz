import java.io.*;
import sun.security.util.*;

public class MyJVMTest_12339 {

    static String type = "d<OZ5p=D& ";

    static String str = "f,OP\"pXTUR";

    static String s = null;

    String verifyString(String type, String str) throws Exception {
        if (!s.equals(str))
            throw new Exception("Problem with string " + type);
        System.out.println(type + "String checks out OK\n");
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12339().verifyString(type, str);
    }
}
