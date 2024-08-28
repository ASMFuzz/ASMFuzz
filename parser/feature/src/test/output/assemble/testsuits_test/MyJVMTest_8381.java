public class MyJVMTest_8381 {

    static char[] a = { Character.MIN_VALUE, Character.MAX_VALUE, 'q', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', Character.MIN_VALUE };

    static char[] b = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '/', Character.MIN_VALUE, Character.MIN_VALUE, '0' };

    char[] test_cp(char[] a, char[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8381().test_cp(a, b);
    }
}
