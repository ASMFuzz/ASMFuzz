public class MyJVMTest_2782 {

    static double i = Double.NaN;

    double foo(double i) {
        return i;
    }

    void dummy() {
    }

    double simpleb_deop(double i) {
        Double ib = Double.valueOf(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2782().simpleb_deop(i));
    }
}
