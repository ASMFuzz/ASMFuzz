public class MyJVMTest_870 {

    static double f = Double.NaN;

    static int i = 0;

    double testb(double f, int i) {
        Double ib = f;
        if ((i & 1) == 0)
            ib = (f + 1.);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_870().testb(f, i));
    }
}
