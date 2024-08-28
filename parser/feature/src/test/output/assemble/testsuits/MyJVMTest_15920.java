public class MyJVMTest_15920 {

    static double f = 0.17173969976697467;

    static int i = -1716675698;

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
        System.out.println(new MyJVMTest_15920().test_deop(f, i));
    }
}
