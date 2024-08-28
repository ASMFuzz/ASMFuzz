public class MyJVMTest_15627 {

    static char[] a = { '0', Character.MAX_VALUE, '7', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0' };

    static char b = Character.MAX_VALUE;

    static int OFFSET = 3;

    char[] test_vi_off(char[] a, char b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15627().test_vi_off(a, b);
    }
}
