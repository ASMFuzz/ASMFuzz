public class MyJVMTest_1280 {

    static char[] a = { Character.MAX_VALUE, '0', Character.MIN_VALUE, 'n', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', '0', '0' };

    static char[] b = { Character.MAX_VALUE, Character.MIN_VALUE, 'w', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '6', 'z', Character.MIN_VALUE, Character.MIN_VALUE };

    char[] test_cp_oppos(char[] a, char[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1280().test_cp_oppos(a, b);
    }
}
