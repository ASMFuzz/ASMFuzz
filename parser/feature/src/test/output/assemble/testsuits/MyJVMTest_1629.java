public class MyJVMTest_1629 {

    static double i = Double.POSITIVE_INFINITY;

    double foo(double i) {
        return i;
    }

    void dummy() {
    }

    double simple_deop(double i) {
        Double ib = new Double(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1629().simple_deop(i));
    }
}
