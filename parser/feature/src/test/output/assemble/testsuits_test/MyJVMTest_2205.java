public class MyJVMTest_2205 {

    static long counter = 0;

    static int mask = 1446383786;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    static XorShift r = new XorShift();

    static long y = 9223372036854775807L;

    long testIntMaskBranch(long counter, int mask) {
        if ((((int) r.nextLong() & mask) != 0)) {
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2205().testIntMaskBranch(counter, mask));
    }
}
