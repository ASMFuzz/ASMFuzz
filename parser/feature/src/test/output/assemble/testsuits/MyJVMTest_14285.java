public class MyJVMTest_14285 {

    static long ctr = -9223372036854775808L;

    static XorShift r = new XorShift();

    static long y = -3536596675580328114L;

    long increment(long ctr) {
        return ctr + 1;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_14285().increment(ctr));
    }
}
