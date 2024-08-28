public class MyJVMTest_1273 {

    static long i = -9223372036854775808L;

    void dummy() {
    }

    static Long ibc = new Long(1);

    long simplec_deop(long i) {
        Long ib = ibc;
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1273().simplec_deop(i));
    }
}
