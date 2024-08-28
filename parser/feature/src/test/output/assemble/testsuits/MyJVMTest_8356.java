public class MyJVMTest_8356 {

    static char[] a = { Character.MAX_VALUE, '0', 'W', '0', '[', ',', 'K', 'T', Character.MAX_VALUE, '(' };

    char[] test_ci_oppos(char[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8356().test_ci_oppos(a);
    }
}
