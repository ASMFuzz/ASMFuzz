import java.nio.CharBuffer;
import java.nio.ByteBuffer;

public class MyJVMTest_820 {

    static char c1 = '0';

    static char c2 = Character.MAX_VALUE;

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

    static String uniTab1 = "YNz`w`1=~t";

    static String uniTab2 = "H7fHGs;EQ)";

    static String uniTab3 = "@Yt.jt}t.z";

    static String uniTab3S = "F33A]mUxbi";

    static String uniTab3S2 = ")J7l:'Q8f8";

    static String uniTab3S3 = "Is?/^A5y\"j";

    static String uniTab3S4 = "X.bEZ[m)~J";

    static String cnsTab1 = "E1=W`DJ\"+`";

    static String cnsTab2 = "n7[<3\"] .%";

    static String cnsTab3 = "/ax8L%)+}b";

    static String cnsTab3S = "Dn?i%ZjiF#";

    static String cnsTab3S2 = "<g2&P4dGy~";

    static String cnsTab3S3 = "`ZR-TVQSlM";

    static String cnsTab3S4 = "y,dH[(i_GN";

    static char[] UniTabS3 = uniTab3S.toCharArray();

    static char[] UniTabS3_2 = uniTab3S2.toCharArray();

    static char[] UniTabS3_3 = uniTab3S3.toCharArray();

    static char[] UniTabS3_4 = uniTab3S4.toCharArray();

    static char[] CNSTab3S = cnsTab3S.toCharArray();

    static char[] CNSTab3S2 = cnsTab3S2.toCharArray();

    static char[] CNSTab3S3 = cnsTab3S3.toCharArray();

    static char[] CNSTab3S4 = cnsTab3S4.toCharArray();

    static char[] CNSTab3 = cnsTab3.toCharArray();

    int getSurrogateEnc(char c1, char c2) {
        int i = -1;
        if ((i = searchTabSurr(c1, c2, UniTabS3)) != -1) {
            return ((CNSTab3S[i] << 16) + CNSTab3S[i + 1]);
        }
        if ((i = searchTabSurr(c1, c2, UniTabS3_2)) != -1) {
            return ((CNSTab3S2[i] << 16) + CNSTab3S2[i + 1]);
        }
        if ((i = searchTabSurr(c1, c2, UniTabS3_3)) != -1) {
            return ((CNSTab3S3[i] << 16) + CNSTab3S3[i + 1]);
        }
        if ((i = searchTabSurr(c1, c2, UniTabS3_4)) != -1) {
            return ((CNSTab3S4[i] << 16) + CNSTab3S4[i + 1]);
        }
        return -1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_820().getSurrogateEnc(c1, c2));
    }
}
