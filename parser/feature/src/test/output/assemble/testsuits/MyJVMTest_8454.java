public class MyJVMTest_8454 {

    static double f = Double.MIN_VALUE;

    static int i = 0;

    double testm(double f, int i) {
        Double ib = f;
        if ((i & 1) == 0)
            ib = new Double(f + 1.);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8454().testm(f, i));
    }
}
