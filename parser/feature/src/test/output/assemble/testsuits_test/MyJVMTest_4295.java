public class MyJVMTest_4295 {

    static long i = 9223372036854775807L;

    long foo(long i) {
        return i;
    }

    void dummy() {
    }

    long testb_deop(long i) {
        Long ib = foo(i);
        if ((i & 1) == 0)
            ib = foo(i + 1);
        dummy();
        return ib;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4295().testb_deop(i));
    }
}
