public class MyJVMTest_10789 {

    static long i = -9223372036854775808L;

    long foo(long i) {
        return i;
    }

    void dummy() {
    }

    long simple_deop(long i) {
        Long ib = new Long(foo(i));
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10789().simple_deop(i));
    }
}
