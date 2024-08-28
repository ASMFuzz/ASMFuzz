import java.nio.CharBuffer;

public class MyJVMTest_6814 {

    static char code = 'R';

    static char[] table = { 'Y', '4', '/', '0', Character.MIN_VALUE, 'u', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'X' };

    static String unicodeCNS1 = "n8XNanORIn";

    static String unicodeCNS2 = "c*0VLjLj5W";

    static String unicodeCNS3 = "|t|E9MU7K*";

    static String unicodeCNS4 = "MxM!e:jwP+";

    static String unicodeCNS5 = "g\\0;Ic_H(J";

    static String unicodeCNS6 = "H U/**bau!";

    static String unicodeCNS7 = "(5s7?#N10%";

    static String unicodeCNS15 = "|j:sk`?[y~";

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
        System.out.println(new MyJVMTest_6814().searchTab(code, table));
    }
}
