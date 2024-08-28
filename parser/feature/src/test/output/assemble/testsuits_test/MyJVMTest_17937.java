public class MyJVMTest_17937 {

    static char[] a = { '0', Character.MIN_VALUE, 'P', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, 'c', '"', '0' };

    char[] test_ci_oppos(char[] a) {
        int limit = a.length - 1;
        for (int i = 0; i < a.length; i += 1) {
            a[limit - i] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17937().test_ci_oppos(a);
    }
}
