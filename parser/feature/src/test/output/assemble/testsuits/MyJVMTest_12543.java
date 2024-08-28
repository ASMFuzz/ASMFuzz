public class MyJVMTest_12543 {

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

    static long y = 9223372036854775807L;

    long testLongSignedBranch(long counter) {
        if (r.nextLong() < 0) {
            counter = increment(counter);
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12543().testLongSignedBranch(counter));
    }
}
