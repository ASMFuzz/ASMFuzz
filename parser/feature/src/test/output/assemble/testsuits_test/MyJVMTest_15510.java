public class MyJVMTest_15510 {

    static char[] a0 = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', '0' };

    static char[] a1 = { Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', Character.MIN_VALUE, '"', '0', Character.MAX_VALUE, 'c', Character.MIN_VALUE };

    static int b = 7;

    char[] test_srlv(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >>> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15510().test_srlv(a0, a1, b);
    }
}
