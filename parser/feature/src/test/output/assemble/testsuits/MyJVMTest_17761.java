public class MyJVMTest_17761 {

    long divint(long a) {
        return a / DIVISOR;
    }

    long divcomp(long a) {
        return a / DIVISOR;
    }

    static long[] DIVIDENDS = { 0, 1, 2, 1423487, 4444441, 4918923241323L, -1, -24351, 0x3333, 0x0000000080000000L, 0x7fffffffffffffffL, 0x8000000000000000L };

    static long DIVISOR = 9223372036854775807L;

    void run() {
        for (int i = 0; i < DIVIDENDS.length; i++) {
            long dividend = DIVIDENDS[i];
            long expected = divint(dividend);
            long result = divcomp(dividend);
            if (result != expected)
                throw new InternalError(dividend + " / " + DIVISOR + " failed: " + result + " != " + expected);
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17761().run();
    }
}
