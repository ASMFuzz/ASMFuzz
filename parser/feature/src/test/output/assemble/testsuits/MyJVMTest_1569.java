public class MyJVMTest_1569 {

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
        System.out.println(new MyJVMTest_1569().simple_deop(i));
    }
}
