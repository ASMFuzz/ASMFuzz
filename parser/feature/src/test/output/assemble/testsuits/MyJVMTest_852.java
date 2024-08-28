import java.nio.charset.*;
import java.nio.*;
import java.util.*;

public class MyJVMTest_852 {

    static Charset oldCS = null;

    static Charset newCS = null;

    static long t = -5167172255483245782L;

    byte[] checkDecoding(Charset oldCS, Charset newCS) throws Exception {
        System.out.printf("Decoding <%s> <%s>...%n", oldCS.name(), newCS.name());
        boolean isEBCDIC = oldCS.name().startsWith("x-IBM93");
        byte[] bb = new byte[1];
        System.out.printf("       trying SB...%n");
        for (int b = 0; b < 0x100; b++) {
            bb[0] = (byte) b;
            String sOld = new String(bb, oldCS);
            String sNew = new String(bb, newCS);
            if (!sOld.equals(sNew)) {
                System.out.printf("        b=%x:  %x/%d(old)  %x/%d(new)%n", b & 0xff, sOld.charAt(0) & 0xffff, sOld.length(), sNew.charAt(0) & 0xffff, sNew.length());
            }
        }
        System.out.printf("       trying DB...%n");
        bb = new byte[isEBCDIC ? 4 : 2];
        int b1Min = 0x40;
        int b1Max = 0xfe;
        for (int b1 = 0x40; b1 < 0xff; b1++) {
            if (!isEBCDIC) {
                bb[0] = (byte) b1;
                String sOld = new String(bb, oldCS);
                String sNew = new String(bb, newCS);
                if (!sOld.equals(sNew)) {
                    if (sOld.length() != 2 && sOld.charAt(0) != 0) {
                        System.out.printf("        b1=%x:  %x/%d(old)  %x/%d(new)%n", b1 & 0xff, sOld.charAt(0) & 0xffff, sOld.length(), sNew.charAt(0) & 0xffff, sNew.length());
                        continue;
                    }
                }
            }
            for (int b2 = 0x40; b2 < 0xff; b2++) {
                if (isEBCDIC) {
                    bb[0] = 0x0e;
                    bb[1] = (byte) b1;
                    bb[2] = (byte) b2;
                    bb[3] = 0x0f;
                } else {
                    bb[0] = (byte) b1;
                    bb[1] = (byte) b2;
                }
                String sOld = new String(bb, oldCS);
                String sNew = new String(bb, newCS);
                if (sOld.charAt(0) != sNew.charAt(0)) {
                    if (sOld.charAt(0) == 0 && sNew.charAt(0) == 0xfffd)
                        continue;
                    System.out.printf("        bb=<%x,%x>  c(old)=%x,  c(new)=%x%n", b1, b2, sOld.charAt(0) & 0xffff, sNew.charAt(0) & 0xffff);
                }
            }
        }
        return bb;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_852().checkDecoding(oldCS, newCS);
    }
}
