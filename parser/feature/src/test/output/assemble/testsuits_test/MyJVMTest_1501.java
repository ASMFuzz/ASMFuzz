public class MyJVMTest_1501 {

    static double i = Double.NEGATIVE_INFINITY;

    void dummy() {
    }

    static Double ibc = new Double(1.);

    double simplec_deop(double i) {
        Double ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1501().simplec_deop(i));
    }
}
