import java.util.BitSet;

public class MyJVMTest_14672 {

    static int sParam1 = 102;

    static StringBuffer s = new StringBuffer(sParam1);

    static char c = Character.MAX_VALUE;

    static BitSet encodedInPath = null;

    StringBuffer escape(StringBuffer s, char c) {
        s.append('%');
        s.append(Character.forDigit((c >> 4) & 0xF, 16));
        s.append(Character.forDigit(c & 0xF, 16));
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14672().escape(s, c);
    }
}
