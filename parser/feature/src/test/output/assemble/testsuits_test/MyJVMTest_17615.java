public class MyJVMTest_17615 {

    static char[] a = { ':', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '/' };

    static char[] b = { Character.MAX_VALUE, '0', Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, 'N' };

    char[] test_2ci(char[] a, char[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17615().test_2ci(a, b);
    }
}
