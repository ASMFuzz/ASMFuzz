public class MyJVMTest_12251 {

    static char[] a = { '0', Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, 'f', Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0' };

    static short[] b = { 32767, -31595, -32768, -32768, 0, 0, 22629, 31537, 32767, 0 };

    char[] test_ci_oppos(char[] a, short[] b) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = (char) -123;
            b[i] = (short) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12251().test_ci_oppos(a, b);
    }
}
