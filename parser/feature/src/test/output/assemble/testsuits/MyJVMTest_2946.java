import java.nio.CharBuffer;
import java.util.Arrays;

public class MyJVMTest_2946 {

    static byte byte1 = 0;

    static byte byte2 = 127;

    static String table = "\\%W>F2Hl.{";

    static String unicodeCNS1 = ")HP:Z+Pepu";

    static String unicodeCNS2 = "\\,J\"Mm+qZ5";

    static String unicodeCNS3 = "QOiLhZev8D";

    static String unicodeCNS4 = ">YFFYKeqC%";

    static String unicodeCNS5 = "2NaLQP#lm~";

    static String unicodeCNS6 = "C| nb<ut&=";

    static String unicodeCNS7 = "|Z?#fyuhOT";

    static String unicodeCNS15 = "B: brs5W\"z";

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
        System.out.println(Arrays.asList(new MyJVMTest_2946().convToSurrogate(byte1, byte2, table)));
    }
}
