public class MyJVMTest_15875 {

    static long i = 3513667184174257046L;

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
        System.out.println(new MyJVMTest_15875().simplef_deop(i));
    }
}
