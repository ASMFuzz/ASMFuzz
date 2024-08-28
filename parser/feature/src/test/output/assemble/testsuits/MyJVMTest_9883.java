public class MyJVMTest_9883 {

    static char[] a0 = { '<', '0', Character.MIN_VALUE, '0', 'G', '8', Character.MIN_VALUE, '0', Character.MIN_VALUE, '0' };

    static char[] a1 = { '0', Character.MAX_VALUE, '0', Character.MAX_VALUE, 'd', '4', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0' };

    static char b = Character.MAX_VALUE;

    char[] test_mulv(char[] a0, char[] a1, char b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] * b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9883().test_mulv(a0, a1, b);
    }
}
