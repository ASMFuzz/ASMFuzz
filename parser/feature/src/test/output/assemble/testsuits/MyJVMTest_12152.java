public class MyJVMTest_12152 {

    static double[] a = { Double.POSITIVE_INFINITY, 0.30734964742280346, Double.NaN, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, Double.MAX_VALUE, Double.NEGATIVE_INFINITY, 0.2648824801968723, Double.MAX_VALUE };

    static Double result = Double.MAX_VALUE;

    double sump(double[] a, Double result) {
        for (Double i : a) result += i;
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12152().sump(a, result));
    }
}
