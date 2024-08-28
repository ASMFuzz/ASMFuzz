public class MyJVMTest_3208 {

    static char[] a = { Character.MIN_VALUE, 'X', Character.MIN_VALUE, Character.MIN_VALUE, '0', 'O', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] b = { '\'', Character.MIN_VALUE, '0', 'C', Character.MIN_VALUE, '%', Character.MIN_VALUE, 'y', Character.MAX_VALUE, '4' };

    char[] test_cp_neg(char[] a, char[] b) {
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3208().test_cp_neg(a, b);
    }
}
