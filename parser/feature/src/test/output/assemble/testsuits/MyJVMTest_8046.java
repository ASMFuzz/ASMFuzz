public class MyJVMTest_8046 {

    static char[] a = { Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, 'Q', '0', '0', Character.MIN_VALUE };

    static char[] b = { '0', '?', 'i', Character.MIN_VALUE, Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, '.' };

    char[] test_2ci(char[] a, char[] b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = (char) -123;
            b[i] = (char) -103;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8046().test_2ci(a, b);
    }
}
