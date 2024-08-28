public class MyJVMTest_9198 {

    static char[] a = { Character.MAX_VALUE, '0', 'n', '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', '0', Character.MIN_VALUE };

    String toHexString(int c) {
        return "0x" + Integer.toHexString(c);
    }

    static char MIN_HIGH = '\uD800';

    static char MAX_LOW = '\uDFFF';

    static boolean At = true, Before = false;

    int test03(char[] a) {
        int cp = 0;
        int ch;
        for (int i = 0; i < a.length; i += Character.charCount(ch)) {
            ch = Character.codePointAt(a, i);
            if (ch != cp) {
                throw new RuntimeException("codePointAt(char[], " + i + ") returned " + toHexString(ch) + ", expected " + toHexString(cp));
            }
            int x = Character.codePointAt(a, i, i + 1);
            if (x != a[i]) {
                throw new RuntimeException(String.format("codePointAt(char[], %d, %d) returned 0x%04x, expected 0x%04x\n", i, i + 1, x, (int) a[i]));
            }
            cp++;
            if (cp == MIN_HIGH) {
                cp = MAX_LOW + 1;
            }
        }
        cp--;
        for (int i = a.length; i > 0; i -= Character.charCount(ch)) {
            ch = Character.codePointBefore(a, i);
            if (ch != cp) {
                throw new RuntimeException("codePointBefore(char[], " + i + ") returned " + toHexString(ch) + ", expected " + toHexString(cp));
            }
            int x = Character.codePointBefore(a, i, i - 1);
            if (x != a[i - 1]) {
                throw new RuntimeException(String.format("codePointAt(char[], %d, %d) returned 0x%04x, expected 0x%04x\n", i, i - 1, x, (int) a[i - 1]));
            }
            cp--;
            if (cp == MAX_LOW) {
                cp = MIN_HIGH - 1;
            }
        }
        return cp;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9198().test03(a);
    }
}
