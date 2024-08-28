public class MyJVMTest_8371 {

    static char[] a = { '.', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, 'g', '0' };

    char[] test_ci_neg(char[] a) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8371().test_ci_neg(a);
    }
}
