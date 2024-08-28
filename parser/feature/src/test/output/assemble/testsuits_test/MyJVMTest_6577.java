public class MyJVMTest_6577 {

    static int[] a0 = { 2080535076, 0, 7, 4, 0, 1361646009, 2, 0, 6, -1945662884 };

    static int[] a1 = { 1567394672, -542671632, 913851740, 1574618882, 0, 0, 0, 1, 7, 1 };

    static int VALUE = 15;

    int[] test_srlc(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >>> VALUE);
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6577().test_srlc(a0, a1);
    }
}
