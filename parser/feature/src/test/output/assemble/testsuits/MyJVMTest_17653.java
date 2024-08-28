public class MyJVMTest_17653 {

    static long i = 9223372036854775807L;

    long foo(long i) {
        return i;
    }

    void dummy() {
    }

    long test_deop(long i) {
        Long ib = new Long(foo(i));
        if ((i & 1) == 0)
            ib = foo(i + 1);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17653().test_deop(i));
    }
}
