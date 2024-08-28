public class MyJVMTest_9531 {

    static char[] a = { Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char b = 'A';

    char[] test_vi_neg(char[] a, char b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9531().test_vi_neg(a, b);
    }
}
