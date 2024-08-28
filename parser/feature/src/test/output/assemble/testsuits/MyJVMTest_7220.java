public class MyJVMTest_7220 {

    static char[] a = { Character.MAX_VALUE, 'b', Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, '0' };

    static int OFFSET = 3;

    char[] test_ci_off(char[] a) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7220().test_ci_off(a);
    }
}
