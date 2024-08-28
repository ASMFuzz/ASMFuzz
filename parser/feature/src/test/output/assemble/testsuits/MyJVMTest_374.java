public class MyJVMTest_374 {

    static char[] a = { Character.MAX_VALUE, '0', 'G', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static char b = Character.MAX_VALUE;

    char[] test_vi_neg(char[] a, char b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_374().test_vi_neg(a, b);
    }
}
