import java.nio.CharBuffer;

public class MyJVMTest_16317 {

    static char code = Character.MAX_VALUE;

    static char[] table = { 'R', Character.MAX_VALUE, '/', '0', '0', '0', '0', Character.MAX_VALUE, '0', '0' };

    static String unicodeCNS1 = "p R@{t1fw>";

    static String unicodeCNS2 = "Q%zmIU::9}";

    static String unicodeCNS3 = "JZ/4+\\,O00";

    static String unicodeCNS4 = "?zn?p\"4GX$";

    static String unicodeCNS5 = "F}lZR6g;53";

    static String unicodeCNS6 = "b~N@RV8AT}";

    static String unicodeCNS7 = "M ?@y`\"S(~";

    static String unicodeCNS15 = "[8At}L*y(/";

    int searchTab(char code, char[] table) {
        int i = 0, l, h;
        for (l = 0, h = table.length - 1; l < h; ) {
            if (table[l] == code) {
                i = l;
                break;
            }
            if (table[h] == code) {
                i = h;
                break;
            }
            i = (l + h) / 2;
            if (table[i] == code)
                break;
            if (table[i] < code)
                l = i + 1;
            else
                h = i - 1;
        }
        if (code == table[i]) {
            return i;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16317().searchTab(code, table));
    }
}
