public class MyJVMTest_15187 {

    static char[] a0 = { Character.MIN_VALUE, Character.MAX_VALUE, '0', '"', '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'W' };

    static char[] a1 = { '0', Character.MAX_VALUE, 'R', Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, 'v', Character.MIN_VALUE, '+' };

    static short b = -26003;

    char[] test_andv(char[] a0, char[] a1, short b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] & b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15187().test_andv(a0, a1, b);
    }
}
