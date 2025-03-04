import java.util.concurrent.Semaphore;

public class MyJVMTest_17998 {

    static int iterations = 1000;

    void test(final boolean fair, final boolean interruptibly) throws Throwable {
        for (int i = 0; i < iterations; i++) {
            final Semaphore sem = new Semaphore(0, fair);
            final Throwable[] badness = new Throwable[1];
            Runnable blocker = interruptibly ? new Runnable() {

                public void run() {
                    try {
                        sem.acquire();
                    } catch (Throwable t) {
                        badness[0] = t;
                        throw new Error(t);
                    }
                }
            } : new Runnable() {

                public void run() {
                    try {
                        sem.acquireUninterruptibly();
                    } catch (Throwable t) {
                        badness[0] = t;
                        throw new Error(t);
                    }
                }
            };
            Thread b1 = new Thread(blocker);
            Thread b2 = new Thread(blocker);
            Runnable signaller = new Runnable() {

                public void run() {
                    try {
                        sem.release();
                    } catch (Throwable t) {
                        badness[0] = t;
                        throw new Error(t);
                    }
                }
            };
            Thread s1 = new Thread(signaller);
            Thread s2 = new Thread(signaller);
            Thread[] threads = { b1, b2, s1, s2 };
            java.util.Collections.shuffle(java.util.Arrays.asList(threads));
            for (Thread thread : threads) thread.start();
            for (Thread thread : threads) {
                thread.join(60 * 1000);
                if (thread.isAlive())
                    throw new Error(String.format("Semaphore stuck: permits %d, thread waiting %s%n", sem.availablePermits(), sem.hasQueuedThreads() ? "true" : "false"));
            }
            if (badness[0] != null)
                throw new Error(badness[0]);
            if (sem.availablePermits() != 0)
                throw new Error(String.valueOf(sem.availablePermits()));
            if (sem.hasQueuedThreads())
                throw new Error(String.valueOf(sem.hasQueuedThreads()));
            if (sem.getQueueLength() != 0)
                throw new Error(String.valueOf(sem.getQueueLength()));
            if (sem.isFair() != fair)
                throw new Error(String.valueOf(sem.isFair()));
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17998().run();
    }
}
