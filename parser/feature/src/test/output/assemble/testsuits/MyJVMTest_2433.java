import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_2433 {

    static char c = Character.MIN_VALUE;

    static Charset cs = null;

    static long t = 0;

    char printEntry(char c, Charset cs) {
        byte[] bb = new String(new char[] { c }).getBytes(cs);
        for (byte b : bb) System.out.printf("%x", b & 0xff);
        System.out.printf("    %x", c & 0xffff);
        String s2 = new String(bb, cs);
        System.out.printf("    %x%n", s2.charAt(0) & 0xffff);
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2433().printEntry(c, cs);
    }
}
