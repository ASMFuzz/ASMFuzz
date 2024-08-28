import java.io.*;
import java.util.*;

public class MyJVMTest_15800 {

    static String s1 = "<<'+^UtNKq";

    static String s2 = "ik]U!A/^;5";

    static String a = "35Q]V=WcZA", b = "g1xeI)!:w`", c = "V#Ysh}S2\"I";

    boolean streq(String s1, String s2) {
        return (s1 != null) ? s1.equals(s2) : (s2 == null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15800().streq(s1, s2));
    }
}
