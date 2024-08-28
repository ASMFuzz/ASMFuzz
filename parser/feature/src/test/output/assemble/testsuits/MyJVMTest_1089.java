public class MyJVMTest_1089 {

    static double val1 = 0.12083195238725664;

    static double val2 = Double.POSITIVE_INFINITY;

    double ulps(double val1, double val2) {
        double diff = Math.abs(val1 - val2);
        double ulpmax = Math.min(Math.ulp(val1), Math.ulp(val2));
        return (diff / ulpmax);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1089().ulps(val1, val2));
    }
}
