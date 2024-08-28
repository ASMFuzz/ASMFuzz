public class MyJVMTest_10630 {

    static char[] a0 = { '+', 'w', Character.MIN_VALUE, '0', 'W', '3', Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] a1 = { '0', Character.MAX_VALUE, '0', ']', '6', '0', Character.MAX_VALUE, 'z', Character.MAX_VALUE, Character.MIN_VALUE };

    static char b = Character.MAX_VALUE;

    char[] test_subv(char[] a0, char[] a1, char b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] - b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10630().test_subv(a0, a1, b);
    }
}
