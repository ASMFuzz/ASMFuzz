public class MyJVMTest_6398 {

    static double f = Double.MIN_VALUE;

    static int i = 9;

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
        System.out.println(new MyJVMTest_6398().testb_deop(f, i));
    }
}
