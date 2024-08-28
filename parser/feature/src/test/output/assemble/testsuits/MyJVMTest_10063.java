public class MyJVMTest_10063 {

    static boolean catchFinalizer = false;

    void alarm(final Thread sleeper, final long delay) throws InterruptedException {
        Thread t = new Thread(new Runnable() {

            public void run() {
                try {
                    Thread.sleep(delay);
                    System.err.println("Waking " + sleeper);
                    sleeper.interrupt();
                } catch (InterruptedException x) {
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10063().run();
    }
}
