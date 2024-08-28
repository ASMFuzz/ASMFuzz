import java.nio.CharBuffer;

public class MyJVMTest_3640 {

    static byte byte1 = 96;

    static byte byte2 = 127;

    static String table = "+^K 4enTIk";

    static char REPLACE_CHAR = '\uFFFD';

    static String unicodeCNS1 = "nizS9r!(!c";

    static String unicodeCNS2 = "V8.e7Q\"3j-";

    static String unicodeCNS3 = "$:C0B6:MY,";

    static String unicodeCNS4 = "b.6n`Wp\"G&";

    static String unicodeCNS5 = "e&5[6f/^XU";

    static String unicodeCNS6 = "2C\"o2]3r9h";

    static String unicodeCNS7 = "IYcl4_pr 6";

    static String unicodeCNS15 = "uJ6gUg$E9]";

    char convToUnicode(byte byte1, byte byte2, String table) {
        int index;
        if ((byte1 & 0xff) < 0xa1 || (byte2 & 0xff) < 0xa1 || (byte1 & 0xff) > 0xfe || (byte2 & 0xff) > 0xfe)
            return REPLACE_CHAR;
        index = (((byte1 & 0xff) - 0xa1) * 94) + (byte2 & 0xff) - 0xa1;
        if (index < 0 || index >= table.length())
            return REPLACE_CHAR;
        return table.charAt(index);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3640().convToUnicode(byte1, byte2, table));
    }
}
