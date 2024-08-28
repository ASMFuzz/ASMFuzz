public class MyJVMTest_16543 {

    static long timeout = 9223372036854775807L;

    static int waitedNB = 0;

    static int counted = 0;

    boolean waiting(long timeout) {
        final long startTime = System.currentTimeMillis();
        long toWait = timeout;
        synchronized (this) {
            while (counted < waitedNB && toWait > 0) {
                try {
                    this.wait(toWait);
                } catch (InterruptedException ire) {
                    break;
                }
                toWait = timeout - (System.currentTimeMillis() - startTime);
            }
        }
        return counted == waitedNB;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16543().waiting(timeout));
    }
}
