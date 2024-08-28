import java.io.*;
import java.util.*;

public class MyJVMTest_6322 {

    static String s1 = "C//$2c0e5H";

    static String s2 = ")6r$AB)iXS";

    static String a = "6E.Ia_e,\\O", b = "hV^Q3,c2`-", c = ",1V}W:RX+A";

    boolean streq(String s1, String s2) {
        return (s1 != null) ? s1.equals(s2) : (s2 == null);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6322().streq(s1, s2));
    }
}
