public class MyJVMTest_5423 {

    static char[] a = { Character.MAX_VALUE, '\\', Character.MIN_VALUE, Character.MAX_VALUE, '0', '0', '0', Character.MAX_VALUE, Character.MAX_VALUE, '0' };

    static int SCALE = 2;

    char[] test_ci_scl(char[] a) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5423().test_ci_scl(a);
    }
}
