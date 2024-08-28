public class MyJVMTest_4343 {

    static double x = Double.NEGATIVE_INFINITY;

    static double b = Double.POSITIVE_INFINITY;

    double log10(double x) {
        return Math.log(x) / Math.log(10);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4343().log10(x));
    }
}
