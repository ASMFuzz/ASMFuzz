import java.io.*;
import sun.security.util.*;
import java.util.Arrays;

public class MyJVMTest_16921 {

    static String s = null;

    byte[] getBytes(String s) {
        int len = s.length();
        byte[] retVal = new byte[len * 2];
        for (int i = 0, j = 0; i < len; i++, j += 2) {
            retVal[j] = (byte) (s.charAt(i) >> 8);
            retVal[j + 1] = (byte) (s.charAt(i));
        }
        return retVal;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_16921().getBytes(s)));
    }
}
