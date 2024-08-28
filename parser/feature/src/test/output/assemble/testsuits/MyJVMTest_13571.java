import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_13571 {

    static Charset oldCS = null;

    static Charset newCS = null;

    void printEntry(char c, Charset cs) {
        byte[] bb = new String(new char[] { c }).getBytes(cs);
        for (byte b : bb) System.out.printf("%x", b & 0xff);
        System.out.printf("    %x", c & 0xffff);
        String s2 = new String(bb, cs);
        System.out.printf("    %x%n", s2.charAt(0) & 0xffff);
    }

    static long t = 9223372036854775807L;

    char[] checkEncoding(Charset oldCS, Charset newCS) throws Exception {
        System.out.printf("Encoding <%s> <%s>...%n", oldCS.name(), newCS.name());
        CharsetEncoder encOLD = oldCS.newEncoder();
        CharsetEncoder encNew = newCS.newEncoder();
        char[] cc = new char[0x10000];
        int pos = 0;
        boolean is970 = "x-IBM970-Old".equals(oldCS.name());
        for (char c = 0; c < 0xffff; c++) {
            boolean canOld = encOLD.canEncode(c);
            boolean canNew = encNew.canEncode(c);
            if (is970 && c == 0x2299)
                continue;
            if (canOld != canNew) {
                if (canNew) {
                    System.out.printf("      NEW(only): ");
                    printEntry(c, newCS);
                } else {
                    if (is970) {
                        byte[] bb = new String(new char[] { c }).getBytes(oldCS);
                        if (bb.length == 2 && bb[0] == (byte) 0xa2 && bb[1] == (byte) 0xc1) {
                            continue;
                        }
                    }
                    System.out.printf("      OLD(only): ");
                    printEntry(c, oldCS);
                }
            } else if (canNew) {
                byte[] bbNew = new String(new char[] { c }).getBytes(newCS);
                byte[] bbOld = new String(new char[] { c }).getBytes(oldCS);
                if (!Arrays.equals(bbNew, bbOld)) {
                    System.out.printf("      c->b NEW: ");
                    printEntry(c, newCS);
                    System.out.printf("      c->b OLD: ");
                    printEntry(c, oldCS);
                } else {
                    String sNew = new String(bbNew, newCS);
                    String sOld = new String(bbOld, oldCS);
                    if (!sNew.equals(sOld)) {
                        System.out.printf("      b2c NEW (c=%x):", c & 0xffff);
                        printEntry(sNew.charAt(0), newCS);
                        System.out.printf("      b2c OLD:");
                        printEntry(sOld.charAt(0), oldCS);
                    }
                }
            }
            if (canNew & canOld) {
                cc[pos++] = c;
            }
        }
        return Arrays.copyOf(cc, pos);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13571().checkEncoding(oldCS, newCS)));
    }
}
