public class MyJVMTest_7327 {

    static char[] a0 = { 'q', Character.MAX_VALUE, Character.MAX_VALUE, ';', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, ';', '3' };

    static char[] a1 = { '7', '>', '>', Character.MIN_VALUE, Character.MIN_VALUE, 'b', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, ':' };

    static int SHIFT = 16;

    char[] test_srac_on(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7327().test_srac_on(a0, a1);
    }
}
