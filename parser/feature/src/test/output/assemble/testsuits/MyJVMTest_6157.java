public class MyJVMTest_6157 {

    static char[] a = { Character.MIN_VALUE, '0', '0', 'L', Character.MIN_VALUE, 'b', 'I', Character.MIN_VALUE, '0', Character.MAX_VALUE };

    static char b = Character.MAX_VALUE;

    static int OFFSET = 3;

    char[] test_vi_off(char[] a, char b) {
        for (int i = 0; i < a.length - OFFSET; i += 1) {
            a[i + OFFSET] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6157().test_vi_off(a, b);
    }
}
