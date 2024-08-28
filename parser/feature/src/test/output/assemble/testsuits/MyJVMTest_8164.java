public class MyJVMTest_8164 {

    static char[] a0 = { '0', '0', '0', Character.MAX_VALUE, '0', 'j', '0', 'r', 'v', Character.MAX_VALUE };

    static char[] a1 = { ':', Character.MIN_VALUE, 'D', Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MIN_VALUE, 'k', 'H', Character.MIN_VALUE };

    static char b = Character.MAX_VALUE;

    char[] test_addv(char[] a0, char[] a1, char b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] + b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8164().test_addv(a0, a1, b);
    }
}
