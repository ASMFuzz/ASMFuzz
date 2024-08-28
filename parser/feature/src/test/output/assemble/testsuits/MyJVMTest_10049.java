public class MyJVMTest_10049 {

    static double f = Double.MIN_VALUE;

    static int i = 3;

    double testb(double f, int i) {
        Double ib = f;
        if ((i & 1) == 0)
            ib = (f + 1.);
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10049().testb(f, i));
    }
}
