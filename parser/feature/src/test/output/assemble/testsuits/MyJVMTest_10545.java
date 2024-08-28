public class MyJVMTest_10545 {

    static long counter = 9223372036854775807L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    long increment(long ctr) {
        return ctr + 1;
    }

    static XorShift r = new XorShift();

    static long y = -3973305327003424004L;

    long testLongBitBranch(long counter) {
        if ((r.nextLong() & (1l << 50)) != 0) {
            counter = increment(counter);
        }
        if ((r.nextLong() & (1l << 50)) != 0) {
            counter = increment(counter);
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10545().testLongBitBranch(counter));
    }
}
