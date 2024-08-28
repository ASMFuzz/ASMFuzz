public class MyJVMTest_14226 {

    static Thread[] threads = { null, null, null, null, null, null, null, null, null, null };

    Thread[] awaitWaitState(Thread[] threads) {
        restart: for (; ; ) {
            for (Thread thread : threads) {
                if (thread.getState() != Thread.State.WAITING) {
                    Thread.yield();
                    continue restart;
                }
            }
            break;
        }
        return threads;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14226().awaitWaitState(threads);
    }
}
