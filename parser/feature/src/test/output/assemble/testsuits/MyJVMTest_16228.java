import java.nio.CharBuffer;

public class MyJVMTest_16228 {

    static char code1 = '0';

    static char code2 = Character.MIN_VALUE;

    static char[] table = { '0', 'G', Character.MAX_VALUE, '0', '*', ';', Character.MAX_VALUE, Character.MIN_VALUE, '0', '0' };

    static String unicodeCNS1 = "tqyWeKsIfe";

    static String unicodeCNS2 = "1Gl$^'M>=g";

    static String unicodeCNS3 = ".Qt)u8v(Yl";

    static String unicodeCNS4 = "[e%,^'m$as";

    static String unicodeCNS5 = "91AaW?}SsU";

    static String unicodeCNS6 = "X?5ta/} hK";

    static String unicodeCNS7 = "IpwK_{dA\\*";

    static String unicodeCNS15 = "]U@b>|)v`W";

    int searchTabSurr(char code1, char code2, char[] table) {
        int i = 0, l, h;
        for (l = 0, h = table.length - 2; l < h; ) {
            if (table[l] == code1 && table[l + 1] == code2) {
                i = l;
                break;
            }
            if (table[h] == code1 && table[h + 1] == code2) {
                i = h;
                break;
            }
            i = (l + h) / 2;
            i = (i % 2 != 0) ? i - 1 : i;
            if (table[i] == code1 && table[i + 1] == code2)
                break;
            int sum = (int) (table[i + 2] - 0xd800) * 0x400 + (int) (table[i + 3] - 0xdc00) + 0x10000;
            int sum2 = (int) (code1 - 0xd800) * 0x400 + (int) (code2 - 0xdc00) + 0x10000;
            if (sum == sum2)
                return (i + 2);
            if (sum < sum2)
                l = i + 2;
            else
                h = i - 2;
        }
        if (code1 == table[i] && code2 == table[i + 1]) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16228().searchTabSurr(code1, code2, table));
    }
}
