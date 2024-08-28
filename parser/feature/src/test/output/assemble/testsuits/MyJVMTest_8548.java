public class MyJVMTest_8548 {

    static long n = -4387277486691362352L;

    boolean isEven(long n) {
        return n % 2 == 0;
    }

    long hailstoneLengthImp(long n) {
        long moves = 0;
        while (n != 1) {
            assert n > 1;
            if (isEven(n)) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            ++moves;
        }
        return moves;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8548().hailstoneLengthImp(n));
    }
}
