public class MyJVMTest_11363 {

    static Double ib = Double.POSITIVE_INFINITY;

    void dummy() {
    }

    double simplep_deop(Double ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11363().simplep_deop(ib));
    }
}
