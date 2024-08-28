public class MyJVMTest_16748 {

    static int[] p2 = { 2, 453412793, 7, 7, 0, 9, 6, 6, 0, -562785305 };

    static char[] a1 = { '}', 'm', Character.MIN_VALUE, '0', Character.MAX_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, '0', Character.MAX_VALUE, '0' };

    int[] test_pack2(int[] p2, char[] a1) {
        if (p2.length * 2 > a1.length)
            return;
        for (int i = 0; i < p2.length; i += 1) {
            int l0 = (int) a1[i * 2 + 0];
            int l1 = (int) a1[i * 2 + 1];
            p2[i] = (l1 << 16) | (l0 & 0xFFFF);
        }
        return p2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16748().test_pack2(p2, a1);
    }
}
