public class MyJVMTest_11781 {

    static CharSequence cs = null;

    String toHexString(int c) {
        return "0x" + Integer.toHexString(c);
    }

    static char MIN_HIGH = '\uD800';

    static char MAX_LOW = '\uDFFF';

    static boolean At = true, Before = false;

    int test02(CharSequence cs) {
        int cp = 0;
        int ch;
        for (int i = 0; i < cs.length(); i += Character.charCount(ch)) {
            ch = Character.codePointAt(cs, i);
            if (ch != cp) {
                throw new RuntimeException("wrong codePointAt(CharSequence, " + i + ") value: got " + toHexString(ch) + ", expected " + toHexString(cp));
            }
            cp++;
            if (cp == MIN_HIGH) {
                cp = MAX_LOW + 1;
            }
        }
        cp--;
        for (int i = cs.length(); i > 0; i -= Character.charCount(ch)) {
            ch = Character.codePointBefore(cs, i);
            if (ch != cp) {
                throw new RuntimeException("codePointBefore(CharSequence, " + i + ") returned " + toHexString(ch) + ", expected " + toHexString(cp));
            }
            cp--;
            if (cp == MAX_LOW) {
                cp = MIN_HIGH - 1;
            }
        }
        return cp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11781().test02(cs);
    }
}
