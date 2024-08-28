public class MyJVMTest_1312 {

    static double[] b1 = { Double.NaN, Double.POSITIVE_INFINITY, 0.47067569015290966, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.NaN, 0.9461667199071949, Double.MIN_VALUE, 0d, 0d };

    static double[] b2 = { Double.POSITIVE_INFINITY, 0.8696632977385071, 0d, 0d, Double.NaN, 0d, Double.POSITIVE_INFINITY, 0d, 0d, Double.MIN_VALUE };

    static int LEN = 500;

    double[] eCheck(double[] b1, double[] b2) {
        for (int k = 0; k < LEN; k++) {
            if (b1[k] != b2[k]) {
                System.out.println("eCheck fails in a[" + k + "]");
                System.out.println("a [" + k + "]=" + b1[k]);
                System.out.println("ao[" + k + "]=" + b2[k]);
                System.out.println("Test subcommon01 Failed.");
                throw new Error("Test subcommon01 Failed: eCheck fails in a[" + k + "]. a[" + k + "]=" + b1[k] + " != ao[" + k + "]=" + b2[k]);
            }
        }
        System.out.println("Test subcommon01 Passed.");
        return b1;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1312().eCheck(b1, b2);
    }
}
