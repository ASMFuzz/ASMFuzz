public class MyJVMTest_16758 {

    static char[] array = { '0', Character.MAX_VALUE, Character.MAX_VALUE, 'h', 'B', Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE };

    static char[] pattern0 = { 0 };

    static char[] pattern1 = { 1 };

    int test(char[] array) {
        if (pattern1 == null)
            return;
        int i = 0;
        int pos = 0;
        char c = array[pos];
        while (i >= 0 && (c == pattern0[i] || c == pattern1[i])) {
            i--;
            pos--;
            if (pos != -1) {
                c = array[pos];
            }
        }
        return pos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16758().test(array);
    }
}
