public class MyJVMTest_16765 {

    static char[] a = { '0', Character.MAX_VALUE, Character.MAX_VALUE, '0', 'Y', '+', 'Q', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE };

    char[] test_ci(char[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16765().test_ci(a);
    }
}
