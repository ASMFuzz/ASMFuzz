public class MyJVMTest_6343 {

    static double i = 0d;

    Double foob(double i) {
        return Double.valueOf(i);
    }

    void dummy() {
    }

    double simplef_deop(double i) {
        Double ib = foob(i);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6343().simplef_deop(i));
    }
}
