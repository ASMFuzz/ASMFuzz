import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class MyJVMTest_3950 {

    static char unicode = '0';

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

    static String uniTab1 = "%:NhNO=2\\$";

    static String uniTab2 = "~RFA*b`?t)";

    static String uniTab3 = "nGbTpJuUz+";

    static String uniTab3S = ".\"9v.|485h";

    static String uniTab3S2 = "T&x%sJdKzn";

    static String uniTab3S3 = "K^PuRl7n`3";

    static String uniTab3S4 = ";<%(lW}x+q";

    static String cnsTab1 = "ayg8{]@e!.";

    static String cnsTab2 = "HO$<FcB`N9";

    static String cnsTab3 = "7y\"aj2kIkF";

    static String cnsTab3S = "Yd.1CMEqSM";

    static String cnsTab3S2 = ":d}H1>-2 y";

    static String cnsTab3S3 = "8F$'ECmEc*";

    static String cnsTab3S4 = "f:wU79:q\"Z";

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
        System.out.println(new MyJVMTest_3950().getNative(unicode));
    }
}
