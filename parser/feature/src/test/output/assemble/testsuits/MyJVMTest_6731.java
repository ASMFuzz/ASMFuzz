import java.nio.CharBuffer;

public class MyJVMTest_6731 {

    static char code1 = '$';

    static char code2 = Character.MAX_VALUE;

    static char[] table = { '!', Character.MAX_VALUE, 'N', '0', Character.MIN_VALUE, Character.MIN_VALUE, '8', Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static String unicodeCNS1 = "V&`kbDz8h2";

    static String unicodeCNS2 = ":+0PS}jpr}";

    static String unicodeCNS3 = "0E?676rw8_";

    static String unicodeCNS4 = "d EApjs$&j";

    static String unicodeCNS5 = "w:AZ9E&vdG";

    static String unicodeCNS6 = "$R+tiK\\zSd";

    static String unicodeCNS7 = ":p<EA*PCkv";

    static String unicodeCNS15 = "\"s!3A_(G<5";

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
        System.out.println(new MyJVMTest_6731().searchTabSurr(code1, code2, table));
    }
}
