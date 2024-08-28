public class MyJVMTest_2713 {

    static double f = Double.MIN_VALUE;

    static int i = 8;

    double testb2(double f, int i) {
        Double ib1 = f;
        Double ib2 = f + 1.;
        if ((i & 1) == 0) {
            ib1 = (f + 1.);
            ib2 = (f + 2.);
        }
        return ib1 + ib2;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2713().testb2(f, i));
    }
}
