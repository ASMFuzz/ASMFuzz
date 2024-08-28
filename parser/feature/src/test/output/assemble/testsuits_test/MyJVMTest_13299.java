import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class MyJVMTest_13299 {

    static char unicode = Character.MIN_VALUE;

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

    static String uniTab1 = "|0Cmux<X&*";

    static String uniTab2 = " G|{ht>vdz";

    static String uniTab3 = "W<S#*Uwk9X";

    static String uniTab3S = "'fg((yj'H^";

    static String uniTab3S2 = "f4qDk_K{d5";

    static String uniTab3S3 = "io }|Z{rbr";

    static String uniTab3S4 = "hUS8n49<mW";

    static String cnsTab1 = "b|/A47wlpF";

    static String cnsTab2 = "a^1=orx'.+";

    static String cnsTab3 = "4uKb%4dQ&v";

    static String cnsTab3S = "+V!$ p0d1M";

    static String cnsTab3S2 = "TQ1mfG4jWI";

    static String cnsTab3S3 = "^T+PF_Ctf`";

    static String cnsTab3S4 = "MFXlX2#UpU";

    static char[] UniTab1 = uniTab1.toCharArray();

    static char[] UniTab2 = uniTab2.toCharArray();

    static char[] UniTab3 = uniTab3.toCharArray();

    static char[] CNSTab1 = cnsTab1.toCharArray();

    static char[] CNSTab2 = cnsTab2.toCharArray();

    static char[] CNSTab3 = cnsTab3.toCharArray();

    int getNative(char unicode) {
        int i, cns;
        if (unicode < UniTab2[0]) {
            if ((i = searchTab(unicode, UniTab1)) == -1)
                return -1;
            cns = (CNSTab1[2 * i] << 16) + CNSTab1[2 * i + 1];
            return cns;
        } else if (unicode < UniTab3[0]) {
            if ((i = searchTab(unicode, UniTab2)) == -1)
                return -1;
            cns = (CNSTab2[2 * i] << 16) + CNSTab2[2 * i + 1];
            return cns;
        } else {
            if ((i = searchTab(unicode, UniTab3)) == -1)
                return -1;
            cns = (CNSTab3[2 * i] << 16) + CNSTab3[2 * i + 1];
            return cns;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13299().getNative(unicode));
    }
}
