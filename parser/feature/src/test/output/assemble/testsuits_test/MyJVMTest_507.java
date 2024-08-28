public class MyJVMTest_507 {

    static char[] a = { Character.MIN_VALUE, '0', Character.MIN_VALUE, '0', '0', Character.MIN_VALUE, 'R', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    static char[] b = { '0', '0', Character.MAX_VALUE, '9', ')', '0', '0', Character.MAX_VALUE, '.', '0' };

    static int ALIGN_OFF = 8;

    char[] test_cp_alnsrc(char[] a, char[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_507().test_cp_alnsrc(a, b);
    }
}
