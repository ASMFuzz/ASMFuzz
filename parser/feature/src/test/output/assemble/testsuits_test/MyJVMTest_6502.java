import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class MyJVMTest_6502 {

    static char code = Character.MIN_VALUE;

    static char[] table = { '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static String uniTab1 = "KahW\"T'!dp";

    static String uniTab2 = "Q-rs_sNz?U";

    static String uniTab3 = "f'2Uyfw4VE";

    static String uniTab3S = "fa,=ecS:!3";

    static String uniTab3S2 = "M1\"&LZJl+@";

    static String uniTab3S3 = "5xz5Un0%^X";

    static String uniTab3S4 = "M'o\"_BXWo0";

    static String cnsTab1 = "KKh(IyM/85";

    static String cnsTab2 = "RTC&3<U:]@";

    static String cnsTab3 = "jYz[(MTuK@";

    static String cnsTab3S = "Xv#3?L*@[/";

    static String cnsTab3S2 = "Cy,aZr-&7f";

    static String cnsTab3S3 = "V[Bmbtug|h";

    static String cnsTab3S4 = ",oz'7~{n4Q";

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
        System.out.println(new MyJVMTest_6502().searchTab(code, table));
    }
}
