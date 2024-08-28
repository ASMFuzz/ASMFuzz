public class MyJVMTest_17919 {

    static char[] a0 = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'q', '0', Character.MAX_VALUE, '-', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { '0', '@', 'h', Character.MAX_VALUE, 'j', '0', Character.MIN_VALUE, Character.MIN_VALUE, '|', '0' };

    static int VALUE = 7;

    char[] test_srac(char[] a0, char[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17919().test_srac(a0, a1);
    }
}
