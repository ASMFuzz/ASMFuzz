public class MyJVMTest_13609 {

    static char[] a0 = { Character.MIN_VALUE, 'Y', '0', 'r', '0', Character.MAX_VALUE, ',', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { Character.MIN_VALUE, '1', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, ',', 'T' };

    static int b = 1;

    static int VALUE = 7;

    char[] test_srav_add(char[] a0, char[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) ((a1[i] + b) >> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13609().test_srav_add(a0, a1, b);
    }
}
