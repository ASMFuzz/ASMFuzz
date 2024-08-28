public class MyJVMTest_14315 {

    static int ITERATIONS = 1000;

    static int doNotOptimizeOut = 0;

    long bitCountShort() {
        long t0 = System.currentTimeMillis();
        int sum = 0;
        for (int it = 0; it < ITERATIONS; ++it) {
            short value = 0;
            do {
                sum += Integer.bitCount(value);
            } while (++value != 0);
        }
        doNotOptimizeOut += sum;
        return System.currentTimeMillis() - t0;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14315().bitCountShort());
    }
}
