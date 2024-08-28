public class MyJVMTest_17721 {

    static long counter = 0;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    long increment(long ctr) {
        return ctr + 1;
    }

    static XorShift r = new XorShift();

    static long y = -4275101432734529740L;

    long testIntBitBranch(long counter) {
        if (((int) r.nextLong() & (1 << 27)) != 0) {
            counter = increment(counter);
        }
        if (((int) r.nextLong() & (1 << 27)) != 0) {
            counter = increment(counter);
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17721().testIntBitBranch(counter));
    }
}
