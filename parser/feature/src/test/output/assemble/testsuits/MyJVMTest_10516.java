public class MyJVMTest_10516 {

    static double[] b1 = { Double.MIN_VALUE, Double.MAX_VALUE, Double.MIN_VALUE, 0.9345713156951665, 0d, 0d, Double.NaN, Double.MIN_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY };

    static double[] b2 = { Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 5.991249988256397E-4, 0d, Double.NEGATIVE_INFINITY, 0d, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.NEGATIVE_INFINITY };

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
        new MyJVMTest_10516().eCheck(b1, b2);
    }
}
