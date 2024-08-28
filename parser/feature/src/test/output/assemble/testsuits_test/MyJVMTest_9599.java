public class MyJVMTest_9599 {

    static double f = Double.MAX_VALUE;

    static int i = 0;

    double testm2(double f, int i) {
        Double ib1 = new Double(f);
        Double ib2 = f + 1.;
        if ((i & 1) == 0) {
            ib1 = new Double(f + 1.);
            ib2 = (f + 2.);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9599().testm2(f, i));
    }
}
