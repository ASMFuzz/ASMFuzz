public class MyJVMTest_1441 {

    static long counter = -9223372036854775808L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    static XorShift r = new XorShift();

    static long y = 0;

    long testLongMaskBranch(long counter) {
        if (((r.nextLong() & 0x0800000000l) != 0)) {
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1441().testLongMaskBranch(counter));
    }
}
