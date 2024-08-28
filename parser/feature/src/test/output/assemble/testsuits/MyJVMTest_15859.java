import java.io.*;
import java.util.*;

public class MyJVMTest_15859 {

    static String s1 = "45=,]qC^M?";

    static String s2 = "Qi>W6`Or,e";

    byte[] diffByteData(String s1, String s2) {
        boolean diff = false;
        byte[] b1 = s1.getBytes();
        byte[] b2 = s2.getBytes();
        if (b1.length != b2.length) {
            diff = true;
            Globals.log("Length differs diff: " + (b1.length - b2.length));
        }
        int minlen = (b1.length < b2.length) ? b1.length : b2.length;
        for (int i = 0; i < b1.length; i++) {
            if (b1[i] != b2[i]) {
                diff = true;
                Globals.log("\t" + "idx[" + i + "] 0x" + Integer.toHexString(b1[i]) + "<>" + "0x" + Integer.toHexString(b2[i]));
            }
        }
        return b1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15859().diffByteData(s1, s2);
    }
}
