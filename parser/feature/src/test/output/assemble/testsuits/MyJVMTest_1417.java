public class MyJVMTest_1417 {

    static char[] a0 = { '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '5', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static char[] a1 = { Character.MAX_VALUE, '0', Character.MIN_VALUE, 'G', '0', '#', Character.MIN_VALUE, Character.MAX_VALUE, '0', 'S' };

    static char b = '0';

    char[] test_subv(char[] a0, char[] a1, char b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (char) (a1[i] - b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1417().test_subv(a0, a1, b);
    }
}
