public class MyJVMTest_15880 {

    static double f = Double.NEGATIVE_INFINITY;

    static int i = -1293890931;

    double foo(double i) {
        return i;
    }

    void dummy() {
    }

    double testb_deop(double f, int i) {
        Double ib = foo(f);
        if ((i & 1) == 0)
            ib = foo(f + 1.);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15880().testb_deop(f, i));
    }
}
