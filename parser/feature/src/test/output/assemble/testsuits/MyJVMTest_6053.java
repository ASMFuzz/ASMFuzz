public class MyJVMTest_6053 {

    static char[] a0 = { Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    static char[] a1 = { '0', '0', 'R', Character.MIN_VALUE, 'C', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static int b = 1177396190;

    char[] test_srlv(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6053().test_srlv(a0, a1, b);
    }
}
