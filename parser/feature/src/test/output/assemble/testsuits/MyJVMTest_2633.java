public class MyJVMTest_2633 {

    static long counter = -9223372036854775808L;

    long nextLong() {
        y ^= (y << 13);
        y ^= (y >>> 17);
        return (y ^= (y << 5));
    }

    long increment(long ctr) {
        return ctr + 1;
    }

    static XorShift r = new XorShift();

    static long y = -7373905394819011997L;

    long testIntSignedBranch(long counter) {
        if ((int) r.nextLong() < 0) {
            counter = increment(counter);
        }
        return counter;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2633().testIntSignedBranch(counter));
    }
}
