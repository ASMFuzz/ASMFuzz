public class MyJVMTest_5744 {

    static char[] a0 = { Character.MIN_VALUE, 'a', '/', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE };

    static char[] a1 = { Character.MAX_VALUE, '*', ';', Character.MAX_VALUE, Character.MAX_VALUE, 'r', Character.MIN_VALUE, '0', '0', '=' };

    static short b = -32768;

    char[] test_andv(char[] a0, char[] a1, short b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] & b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5744().test_andv(a0, a1, b);
    }
}
