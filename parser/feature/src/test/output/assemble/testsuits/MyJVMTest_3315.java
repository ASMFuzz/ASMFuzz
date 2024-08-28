public class MyJVMTest_3315 {

    static char[] a = { Character.MIN_VALUE, Character.MAX_VALUE, 'O', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '*', Character.MAX_VALUE, '0' };

    static char[] b = { 'D', Character.MAX_VALUE, Character.MIN_VALUE, '0', '0', '0', Character.MIN_VALUE, '0', 'u', Character.MIN_VALUE };

    char[] test_2ci_oppos(char[] a, char[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3315().test_2ci_oppos(a, b);
    }
}
