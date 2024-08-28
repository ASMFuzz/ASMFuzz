public class MyJVMTest_13366 {

    static long counter = 9223372036854775807L;

    static long mask = 0;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    static XorShift r = new XorShift();

    static long y = 5127306270138280808L;

    long testLongMaskBranch(long counter, long mask) {
        if (((r.nextLong() & mask) != 0)) {
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13366().testLongMaskBranch(counter, mask));
    }
}
