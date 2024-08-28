public class MyJVMTest_2065 {

    static char[] a = { Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, 'r', '0', Character.MAX_VALUE, Character.MAX_VALUE };

    static char b = Character.MAX_VALUE;

    char[] test_vi(char[] a, char b) {
        for (int i = 0; i < a.length; i += 1) {
            a[i] = b;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2065().test_vi(a, b);
    }
}
