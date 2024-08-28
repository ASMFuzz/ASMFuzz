public class MyJVMTest_10625 {

    static double[] arr = { 0d, Double.NaN, Double.MAX_VALUE, Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 0d, Double.MIN_VALUE, 0.2718879015650263, Double.MAX_VALUE };

    double[] pt(double[] arr) {
        System.out.println();
        for (int k = 0; k < 10; k++) System.out.print("a[" + k + "]=" + arr[k]);
        return arr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10625().pt(arr);
    }
}
