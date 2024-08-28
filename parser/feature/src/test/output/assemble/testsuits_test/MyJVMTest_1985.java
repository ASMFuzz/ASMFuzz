import java.util.*;

public class MyJVMTest_1985 {

    static long idlePeriod = 300;

    long idleLoop(long idlePeriod) {
        System.out.println("Idling ... ");
        long startTime = System.nanoTime();
        long sleepTime = idlePeriod * 1000;
        do {
            try {
                Thread.currentThread().sleep(sleepTime);
            } catch (Exception e) {
            } finally {
                long elapsed = (System.nanoTime() - startTime) / 1000000L;
                sleepTime = sleepTime - elapsed;
            }
        } while (sleepTime > 0);
        System.out.println("Idling done");
        return sleepTime;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1985().idleLoop(idlePeriod);
    }
}
