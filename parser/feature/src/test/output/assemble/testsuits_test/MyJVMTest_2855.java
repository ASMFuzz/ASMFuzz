public class MyJVMTest_2855 {

    static double[] a = { Double.MIN_VALUE, 0d, Double.NaN, Double.POSITIVE_INFINITY, Double.NaN, Double.MAX_VALUE, 0d, 0d, Double.MIN_VALUE, Double.MAX_VALUE };

    static Double result = Double.NaN;

    double sump(double[] a, Double result) {
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2855().sump(a, result));
    }
}
