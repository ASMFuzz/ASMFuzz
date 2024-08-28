public class MyJVMTest_16743 {

    static char[] a = { 'A', Character.MIN_VALUE, 'F', 'A', Character.MIN_VALUE, '7', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE };

    static int OFFSET = 3;

    char[] test_ci_off(char[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16743().test_ci_off(a);
    }
}
