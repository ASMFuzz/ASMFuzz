public class MyJVMTest_4013 {

    static long counter = -9223372036854775808L;

    static long mask = -9223372036854775808L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    static XorShift r = new XorShift();

    static long y = -354834676713426914L;

    long testLongMaskBranch(long counter, long mask) {
        if (((r.nextLong() & mask) != 0)) {
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4013().testLongMaskBranch(counter, mask));
    }
}
