public class MyJVMTest_4137 {

    static int[] a0 = { 1, 203107576, 0, 4, 8, 0, 5, 0, -1704542456, 1456006665 };

    static int[] a1 = { 0, 5, 483074902, 0, 0, 0, 0, 687245196, 3, 9 };

    static int b = 0;

    int[] test_xorv(int[] a0, int[] a1, int b) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] ^ b);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4137().test_xorv(a0, a1, b);
    }
}
