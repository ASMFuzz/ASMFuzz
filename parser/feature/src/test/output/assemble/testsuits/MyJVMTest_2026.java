public class MyJVMTest_2026 {

    static double i = Double.MAX_VALUE;

    static Double ib1 = Double.MAX_VALUE;

    double simplep2(double i, Double ib1) {
        Double ib2 = Double.valueOf(i + 1.);
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2026().simplep2(i, ib1));
    }
}
