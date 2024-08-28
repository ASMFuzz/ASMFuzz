public class MyJVMTest_7985 {

    static char[] a = { Character.MAX_VALUE, '0', '0', '0', '0', 's', Character.MAX_VALUE, '0', '0', 'E' };

    static short[] b = { 19398, 13363, 0, 0, -32768, 0, 0, 15286, 24035, 32767 };

    static char c = Character.MAX_VALUE;

    static short d = 32767;

    char[] test_vi_oppos(char[] a, short[] b, char c, short d) {
        int limit = a.length - 1;
        for (int i = a.length - 1; i >= 0; i -= 1) {
            a[i] = c;
            b[limit - i] = d;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7985().test_vi_oppos(a, b, c, d);
    }
}
