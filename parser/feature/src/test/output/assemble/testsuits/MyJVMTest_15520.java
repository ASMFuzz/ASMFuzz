public class MyJVMTest_15520 {

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = -1061546479;

    static long quittingTime = -9223372036854775808L;

    static int i = 0;

    boolean keepGoing() {
        return (i++ % 128 != 0) || (System.nanoTime() - quittingTime < 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15520().keepGoing());
    }
}
