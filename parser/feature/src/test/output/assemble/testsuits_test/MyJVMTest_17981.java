public class MyJVMTest_17981 {

    static double f = Double.POSITIVE_INFINITY;

    static int i = 4;

    double test2(double f, int i) {
        Double ib1 = new Double(f);
        Double ib2 = new Double(f + 1.);
        if ((i & 1) == 0) {
            ib1 = new Double(f + 1.);
            ib2 = new Double(f + 2.);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17981().test2(f, i));
    }
}
