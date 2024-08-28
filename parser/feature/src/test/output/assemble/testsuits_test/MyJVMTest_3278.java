public class MyJVMTest_3278 {

    static Long ib = 9223372036854775807L;

    void dummy() {
    }

    long simplep_deop(Long ib) {
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3278().simplep_deop(ib));
    }
}
