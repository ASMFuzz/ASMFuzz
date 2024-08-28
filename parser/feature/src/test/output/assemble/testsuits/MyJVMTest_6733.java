public class MyJVMTest_6733 {

    static Float ib = Float.NaN;

    void dummy() {
    }

    float simplep_deop(Float ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6733().simplep_deop(ib));
    }
}
