import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class MyJVMTest_15991 {

    static char code = '0';

    static char[] table = { '0', '0', '>', Character.MAX_VALUE, Character.MAX_VALUE, '0', ',', 'v', Character.MAX_VALUE, Character.MAX_VALUE };

    static String uniTab1 = "CBs7jnnio`";

    static String uniTab2 = "n,4E^BKHS ";

    static String uniTab3 = "b/o,&VwAl@";

    static String uniTab3S = "/Lsav]u>u#";

    static String uniTab3S2 = "c(lW{I{^o;";

    static String uniTab3S3 = "FA&+/a{%~Z";

    static String uniTab3S4 = "aJ&sg{ow^=";

    static String cnsTab1 = "G1Lv2a.<< ";

    static String cnsTab2 = "b!xAO2<wG)";

    static String cnsTab3 = "J]hRpZJ'ux";

    static String cnsTab3S = "nZ1jGjN#.g";

    static String cnsTab3S2 = "@y&=gJkM3n";

    static String cnsTab3S3 = "WgF0f.A'Dk";

    static String cnsTab3S4 = "O^&|P,Ko1c";

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
        System.out.println(new MyJVMTest_15991().searchTab(code, table));
    }
}
