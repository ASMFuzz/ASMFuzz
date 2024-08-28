public class MyJVMTest_16230 {

    static Float ib = 0f;

    void dummy() {
    }

    float simplep_deop(Float ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16230().simplep_deop(ib));
    }
}
