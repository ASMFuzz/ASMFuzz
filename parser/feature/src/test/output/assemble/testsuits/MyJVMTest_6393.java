public class MyJVMTest_6393 {

    static long i = 9223372036854775807L;

    Long foob(long i) {
        return Long.valueOf(i);
    }

    void dummy() {
    }

    long simplef_deop(long i) {
        Long ib = foob(i);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6393().simplef_deop(i));
    }
}
