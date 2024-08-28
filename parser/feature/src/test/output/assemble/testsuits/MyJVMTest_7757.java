public class MyJVMTest_7757 {

    static char[] a0 = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE };

    static char[] a1 = { Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '8', '0', 'h', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE };

    static int b = 3;

    static int VALUE = 7;

    char[] test_srav_and(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] & b) >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7757().test_srav_and(a0, a1, b);
    }
}
