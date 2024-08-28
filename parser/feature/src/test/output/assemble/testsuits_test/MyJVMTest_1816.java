import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class MyJVMTest_1816 {

    static char code1 = Character.MAX_VALUE;

    static char code2 = '0';

    static char[] table = { Character.MIN_VALUE, '|', '0', Character.MIN_VALUE, 's', '>', ')', 'z', Character.MIN_VALUE, Character.MIN_VALUE };

    static String uniTab1 = "/jd$~p#\\&K";

    static String uniTab2 = "SLi7ZSX{*L";

    static String uniTab3 = ">7!1%:)fJ2";

    static String uniTab3S = "OM-=_`v')H";

    static String uniTab3S2 = "v<B%1Kjyr7";

    static String uniTab3S3 = "Y(&WMA#/Fv";

    static String uniTab3S4 = "@P\"!a_hku2";

    static String cnsTab1 = "P,q'}D?H@e";

    static String cnsTab2 = "<GT\"s<{2=6";

    static String cnsTab3 = "c7\\tIKm$SC";

    static String cnsTab3S = "H(nSk!%qFY";

    static String cnsTab3S2 = "6)=\"OLlzA1";

    static String cnsTab3S3 = "3EFFpl2'Y8";

    static String cnsTab3S4 = "f?GpE')VRt";

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
        System.out.println(new MyJVMTest_1816().searchTabSurr(code1, code2, table));
    }
}
