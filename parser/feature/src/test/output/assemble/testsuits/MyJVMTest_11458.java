public class MyJVMTest_11458 {

    static long counter = 9223372036854775807L;

    static int mask = 9;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    static XorShift r = new XorShift();

    static long y = 0;

    long testIntMaskBranch(long counter, int mask) {
        if ((((int) r.nextLong() & mask) != 0)) {
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11458().testIntMaskBranch(counter, mask));
    }
}
