public class MyJVMTest_10851 {

    static double i = 0d;

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
        System.out.println(new MyJVMTest_10851().simple_deop(i));
    }
}
