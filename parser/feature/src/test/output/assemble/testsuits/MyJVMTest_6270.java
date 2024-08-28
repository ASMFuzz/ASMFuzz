public class MyJVMTest_6270 {

    static double f = Double.POSITIVE_INFINITY;

    static int i = -1892349355;

    double test(double f, int i) {
        Double ib = new Double(f);
        if ((i & 1) == 0)
            ib = f + 1.;
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6270().test(f, i));
    }
}
