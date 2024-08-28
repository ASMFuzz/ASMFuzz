public class MyJVMTest_12075 {

    static double i = 0d;

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
        System.out.println(new MyJVMTest_12075().simpleb_deop(i));
    }
}
