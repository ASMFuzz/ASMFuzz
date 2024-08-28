public class MyJVMTest_14481 {

    static double f = Double.NEGATIVE_INFINITY;

    static int i = 4;

    static Double ib1 = 0.7955495817633575;

    double testp2(double f, int i, Double ib1) {
        Double ib2 = f + 1.;
        if ((i & 1) == 0) {
            ib1 = new Double(f + 1.);
            ib2 = (f + 2.);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14481().testp2(f, i, ib1));
    }
}
