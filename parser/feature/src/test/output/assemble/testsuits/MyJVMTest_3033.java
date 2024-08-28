import java.io.*;
import sun.security.util.*;

public class MyJVMTest_3033 {

    static String type = "B<ByH<BdKO";

    static String str = "Pyy:P5svF)";

    static String s = null;

    String verifyString(String type, String str) throws Exception {
        if (!s.equals(str))
            throw new Exception("Problem with string " + type);
        System.out.println(type + "String checks out OK\n");
        return type;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3033().verifyString(type, str);
    }
}
