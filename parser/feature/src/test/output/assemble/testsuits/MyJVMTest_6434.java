public class MyJVMTest_6434 {

    static double f = Double.POSITIVE_INFINITY;

    static int i = 9;

    double foo(double i) {
        return i;
    }

    void dummy() {
    }

    double test_deop(double f, int i) {
        Double ib = new Double(foo(f));
        if ((i & 1) == 0)
            ib = foo(f + 1.);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6434().test_deop(f, i));
    }
}
