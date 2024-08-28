import java.nio.CharBuffer;
import java.util.Arrays;

public class MyJVMTest_12249 {

    static byte byte1 = 81;

    static byte byte2 = 127;

    static String table = "-QSe$LG=gE";

    static String unicodeCNS1 = "DJNZ?.dBCC";

    static String unicodeCNS2 = "k\"u ps)K-,";

    static String unicodeCNS3 = "wHZ$1I(rx<";

    static String unicodeCNS4 = "E_#s1K)*f$";

    static String unicodeCNS5 = "UJ|`Rw-sFn";

    static String unicodeCNS6 = "CkP5KESF1c";

    static String unicodeCNS7 = "P5=1v(ka'e";

    static String unicodeCNS15 = ":V%c/_qM$V";

    char[] convToSurrogate(byte byte1, byte byte2, String table) {
        int index;
        char[] surr = new char[2];
        if ((byte1 & 0xff) < 0xa1 || (byte2 & 0xff) < 0xa1 || (byte1 & 0xff) > 0xfe || (byte2 & 0xff) > 0xfe)
            return null;
        index = (((byte1 & 0xff) - 0xa1) * 94) + (byte2 & 0xff) - 0xa1;
        index *= 2;
        if (index < 0 || index >= table.length())
            return null;
        surr[0] = table.charAt(index);
        surr[1] = table.charAt(index + 1);
        return surr;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_12249().convToSurrogate(byte1, byte2, table)));
    }
}
