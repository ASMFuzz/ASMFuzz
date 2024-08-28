public class MyJVMTest_12525 {

    static char[] a = { '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] b = { '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, ')', Character.MAX_VALUE, '0', '0', 's', '#' };

    char[] test_cp_neg(char[] a, char[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12525().test_cp_neg(a, b);
    }
}
