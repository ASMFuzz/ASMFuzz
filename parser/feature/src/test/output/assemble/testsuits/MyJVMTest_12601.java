public class MyJVMTest_12601 {

    static Long ib = -9223372036854775808L;

    void dummy() {
    }

    long simplep_deop(Long ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12601().simplep_deop(ib));
    }
}
