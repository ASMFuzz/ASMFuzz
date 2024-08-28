public class MyJVMTest_11270 {

    static double i = Double.NaN;

    static Double ib1 = Double.NEGATIVE_INFINITY;

    double simplep2(double i, Double ib1) {
        Double ib2 = Double.valueOf(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11270().simplep2(i, ib1));
    }
}
