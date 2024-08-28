public class MyJVMTest_13671 {

    static char[] a = { '$', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, '}', '0', '0', Character.MAX_VALUE, 'D' };

    static char b = '0';

    static int SCALE = 2;

    char[] test_vi_scl(char[] a, char b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13671().test_vi_scl(a, b);
    }
}
