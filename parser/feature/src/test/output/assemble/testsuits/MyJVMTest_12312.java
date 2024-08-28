public class MyJVMTest_12312 {

    long fint(long x) {
        return x % DIVISOR;
    }

    long fcomp(long x) {
        return x % DIVISOR;
    }

    static long DIVISOR = 0;

    void run() {
        long a = 0x617981E1L;
        long expected = fint(a);
        long result = fcomp(a);
        if (result != expected)
            throw new InternalError(result + " != " + expected);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12312().run();
    }
}
