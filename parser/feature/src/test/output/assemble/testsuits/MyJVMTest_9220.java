public class MyJVMTest_9220 {

    static int[] a0 = { 6, 5, 0, 0, 7, 0, 0, 8, 3, 2 };

    static int[] a1 = { 3, -454758289, 5, 8, 6, -1381297032, -1679530367, 1, 4, 0 };

    static int[] a2 = { 3, 4, 0, 8, 9, 5, 9, 5, 873765089, 0 };

    int[] test_xora(int[] a0, int[] a1, int[] a2) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] ^ a2[i]);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9220().test_xora(a0, a1, a2);
    }
}
