public class MyJVMTest_7242 {

    static char[] a = { '0', Character.MIN_VALUE, '0', Character.MAX_VALUE, '0', '0', '0', 'Q', '0', 'q' };

    char[] test_ci(char[] a) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = (char) -123;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7242().test_ci(a);
    }
}
