public class MyJVMTest_2948 {

    static char[] a = { ')', 'x', 'p', '0', '0', Character.MIN_VALUE, 'o', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static short[] b = { 0, -29377, 669, 11866, 15342, 337, -17073, 5951, 32767, 32767 };

    char[] test_ci_oppos(char[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2948().test_ci_oppos(a, b);
    }
}
