public class MyJVMTest_11143 {

    static long time = 9223372036854775807L;

    Object doSleep(long time) throws InterruptedException {
        Object lock = new Object();
        synchronized (lock) {
            lock.wait(time);
        }
        return lock;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11143().doSleep(time);
    }
}
