public class MyJVMTest_10484 {

    static char[] a = { Character.MIN_VALUE, '0', '3', Character.MIN_VALUE, Character.MIN_VALUE, 'u', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] b = { 'v', Character.MAX_VALUE, Character.MAX_VALUE, '0', '9', ',', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'R' };

    char[] test_cp_oppos(char[] a, char[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b[limit - i];
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10484().test_cp_oppos(a, b);
    }
}
