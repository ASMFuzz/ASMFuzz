public class MyJVMTest_6824 {

    static char[] a0 = { '>', Character.MIN_VALUE, '0', '0', '&', '0', '0', Character.MIN_VALUE, Character.MAX_VALUE, Character.MIN_VALUE };

    static int[] p2 = { 0, 0, 246411377, 0, -1820683529, -1623821649, 3, -673838242, 0, -2042605925 };

    char[] test_unpack2(char[] a0, int[] p2) {
        if (p2.length * 2 > a0.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            int l = p2[i];
            a0[i * 2 + 0] = (char) (l & 0xFFFF);
            a0[i * 2 + 1] = (char) (l >> 16);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6824().test_unpack2(a0, p2);
    }
}
