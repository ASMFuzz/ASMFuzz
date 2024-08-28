public class MyJVMTest_9669 {

    static char[] a = { '0', '0', '0', '_', '0', 'N', Character.MAX_VALUE, Character.MIN_VALUE, 'j', Character.MAX_VALUE };

    static char[] b = { '0', '0', 'W', 'd', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, 'm' };

    static int ALIGN_OFF = 8;

    char[] test_cp_alnsrc(char[] a, char[] b) {
        for (int i = 0; i < a.length - ALIGN_OFF; i += 1) {
            a[i] = b[i + ALIGN_OFF];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9669().test_cp_alnsrc(a, b);
    }
}
