public class MyJVMTest_1233 {

    static char[] a0 = { '0', 'd', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, '8', 'U', '0', Character.MIN_VALUE };

    static char[] a1 = { Character.MAX_VALUE, '0', Character.MIN_VALUE, '5', '+', 'p', '0', Character.MIN_VALUE, Character.MAX_VALUE, '>' };

    static int b = 100398819;

    char[] test_srav(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1233().test_srav(a0, a1, b);
    }
}
