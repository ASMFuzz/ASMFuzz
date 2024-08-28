public class MyJVMTest_15746 {

    static double f = Double.POSITIVE_INFINITY;

    static int i = 9;

    double test(double f, int i) {
        Double ib = new Double(f);
        if ((i & 1) == 0)
            ib = f + 1.;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15746().test(f, i));
    }
}
