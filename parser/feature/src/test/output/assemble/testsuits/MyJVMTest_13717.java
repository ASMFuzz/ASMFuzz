public class MyJVMTest_13717 {

    static double x = Double.MIN_VALUE;

    static double b = Double.NEGATIVE_INFINITY;

    double log10(double x) {
        return Math.log(x) / Math.log(10);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13717().log10(x));
    }
}
