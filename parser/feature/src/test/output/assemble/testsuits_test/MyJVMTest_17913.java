public class MyJVMTest_17913 {

    static char[] a = { Character.MAX_VALUE, 'd', '0', '1', '0', Character.MIN_VALUE, Character.MAX_VALUE, 'Q', Character.MAX_VALUE, Character.MAX_VALUE };

    static short[] b = { 28490, -32768, 0, -29380, -32768, 0, 0, 9402, 1826, 0 };

    char[] test_ci(char[] a, short[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17913().test_ci(a, b);
    }
}
