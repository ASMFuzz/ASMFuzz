public class MyJVMTest_1412 {

    static double[] arr = { Double.MIN_VALUE, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.MAX_VALUE, Double.NaN, Double.MAX_VALUE, Double.POSITIVE_INFINITY, Double.MIN_VALUE, Double.MIN_VALUE, 0.19127533283898634 };

    double[] pt(double[] arr) {
        System.out.println();
        for (int k = 0; k < 10; k++) System.out.print("a[" + k + "]=" + arr[k]);
        return arr;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1412().pt(arr);
    }
}
