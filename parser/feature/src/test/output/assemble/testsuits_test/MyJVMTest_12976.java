import java.nio.CharBuffer;

public class MyJVMTest_12976 {

    static byte byte1 = 127;

    static byte byte2 = 127;

    static String table = "BinvMs,=F\\";

    static char REPLACE_CHAR = '\uFFFD';

    static String unicodeCNS1 = " U$)clx]Hb";

    static String unicodeCNS2 = "{zWvb+`Eiv";

    static String unicodeCNS3 = "WJ_UhyqRgP";

    static String unicodeCNS4 = "guW#MbXdHE";

    static String unicodeCNS5 = "AL>XyWu<i~";

    static String unicodeCNS6 = "$fdl+C{<6P";

    static String unicodeCNS7 = "7b%wo'JiO4";

    static String unicodeCNS15 = "tYHF>\"YNE5";

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
        System.out.println(new MyJVMTest_12976().convToUnicode(byte1, byte2, table));
    }
}
