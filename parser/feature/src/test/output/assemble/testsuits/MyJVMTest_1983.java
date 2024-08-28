import java.io.*;
import java.util.*;

public class MyJVMTest_1983 {

    static String s1 = "t-xjsTH]&j";

    static String s2 = "2lX&B#4|-D";

    char[] diffCharData(String s1, String s2) {
        boolean diff = false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if (c1.length != c2.length) {
            diff = true;
            Globals.log("Length differs: " + (c1.length - c2.length));
        }
        int minlen = (c1.length < c2.length) ? c1.length : c2.length;
        for (int i = 0; i < c1.length; i++) {
            if (c1[i] != c2[i]) {
                diff = true;
                Globals.lognoln("\t idx[" + i + "] 0x" + Integer.toHexString(c1[i]) + "<>" + "0x" + Integer.toHexString(c2[i]));
                Globals.log(" -> " + c1[i] + "<>" + c2[i]);
            }
        }
        return c1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1983().diffCharData(s1, s2);
    }
}
