public class MyJVMTest_11216 {

    static char[] a = { Character.MIN_VALUE, Character.MIN_VALUE, 'E', 'Y', '0', 'C', Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE };

    static char[] b = { Character.MIN_VALUE, Character.MAX_VALUE, '0', '|', '4', ':', Character.MIN_VALUE, Character.MAX_VALUE, ';', Character.MIN_VALUE };

    static int SCALE = 2;

    char[] test_2ci_scl(char[] a, char[] b) {
        for (int i = 0; i * SCALE < a.length; i += 1) {
            a[i * SCALE] = (char) -123;
            b[i * SCALE] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11216().test_2ci_scl(a, b);
    }
}
