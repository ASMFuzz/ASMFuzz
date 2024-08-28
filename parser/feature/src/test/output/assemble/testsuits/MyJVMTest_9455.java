public class MyJVMTest_9455 {

    static int[] a0 = { 0, 3, 0, 5, 0, -1466548883, 2, 7, 2, 0 };

    static int[] a1 = { -1157115182, 5, 0, 9, 0, 1641967813, -987597875, -1529589777, 3, 0 };

    static int SHIFT = 32;

    int[] test_srac_on(int[] a0, int[] a1) {
        for (int i = 0; i < a0.length; i += 1) {
            a0[i] = (int) (a1[i] >> (-SHIFT));
        }
        return a0;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9455().test_srac_on(a0, a1);
    }
}
