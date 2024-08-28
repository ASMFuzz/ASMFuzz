public class MyJVMTest_4391 {

    static Object go = new Object();

    static int count = 0;

    static int waiters = 0;

    void await() {
        synchronized (go) {
            waiters++;
            while (count > 0) {
                try {
                    go.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    throw new InternalError();
                }
            }
            waiters--;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4391().await();
    }
}
