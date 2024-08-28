public class MyJVMTest_10628 {

    static long counter = -8237405395154496295L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    static XorShift r = new XorShift();

    static long y = 9223372036854775807L;

    long testIntMaskBranch(long counter) {
        if ((((int) r.nextLong() & 0x08) != 0)) {
            counter++;
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10628().testIntMaskBranch(counter));
    }
}
