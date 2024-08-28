import java.util.*;
import java.nio.*;
import java.nio.charset.*;

public class MyJVMTest_13812 {

    static String csn = "-OJ@y#6ZU>";

    static int failures = 0;

    static byte[] asciiBytes = new byte[0x80];

    static String asciiString = "hQm]dMS;4M";

    String check(String csn) throws Exception {
        System.out.println(csn);
        if (!Arrays.equals(asciiString.getBytes(csn), asciiBytes)) {
            System.out.printf("%s -> bytes%n", csn);
            failures++;
        }
        if (!new String(asciiBytes, csn).equals(asciiString)) {
            System.out.printf("%s -> chars%n", csn);
            failures++;
        }
        return csn;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13812().check(csn);
    }
}
