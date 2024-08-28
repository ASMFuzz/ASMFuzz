public class MyJVMTest_7128 {

    static double f = Double.POSITIVE_INFINITY;

    static int i = 1;

    static Double ibc = new Double(1.);

    double testc(double f, int i) {
        Double ib = ibc;
        if ((i & 1) == 0)
            ib = new Double(f + 1.);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7128().testc(f, i));
    }
}
