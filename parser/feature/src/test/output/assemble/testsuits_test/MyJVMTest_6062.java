public class MyJVMTest_6062 {

    static long defaultWorkTimeMillis = Long.getLong("millis", 10L);

    static Object elLoco = 0;

    static long quittingTime = 0;

    static int i = 0;

    boolean keepGoing() {
        return (i++ % 128 != 0) || (System.nanoTime() - quittingTime < 0);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6062().keepGoing());
    }
}
