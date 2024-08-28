public class MyJVMTest_3006 {

    long fint(long x) {
        return x % DIVISOR;
    }

    long fcomp(long x) {
        return x % DIVISOR;
    }

    static long DIVISOR = -9223372036854775808L;

    void run() {
        long a = 0x617981E1L;
        long expected = fint(a);
        long result = fcomp(a);
        if (result != expected)
            throw new InternalError(result + " != " + expected);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3006().run();
    }
}
