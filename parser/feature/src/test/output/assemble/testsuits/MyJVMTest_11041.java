import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class MyJVMTest_11041 {

    static char code1 = Character.MIN_VALUE;

    static char code2 = Character.MAX_VALUE;

    static char[] table = { Character.MAX_VALUE, Character.MAX_VALUE, '0', 'D', '0', 'M', 'R', '0', 'r', '0' };

    static String uniTab1 = "@zuT;\\6#_e";

    static String uniTab2 = "05(z-n)Fg<";

    static String uniTab3 = "!Tg|{z=f&K";

    static String uniTab3S = "?7.E:4RAwy";

    static String uniTab3S2 = "znQ\"nSi<@W";

    static String uniTab3S3 = ";\")RH@$VV7";

    static String uniTab3S4 = "3N97+RJ/@S";

    static String cnsTab1 = "C+E-*bM8>$";

    static String cnsTab2 = "b8O7G4u;a<";

    static String cnsTab3 = "/B z\"o_8HL";

    static String cnsTab3S = ",mK#0ErfX7";

    static String cnsTab3S2 = "~'H-W]=KRJ";

    static String cnsTab3S3 = "l7e\"fY{OpC";

    static String cnsTab3S4 = "@{BBCep9$W";

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
        System.out.println(new MyJVMTest_11041().searchTabSurr(code1, code2, table));
    }
}
