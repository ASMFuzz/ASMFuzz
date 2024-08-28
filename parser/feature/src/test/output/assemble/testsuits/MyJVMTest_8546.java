public class MyJVMTest_8546 {

    static Thread main = null;

    void run() {
        main = Thread.currentThread();
        (new Thread() {

            public void run() {
                while (true) {
                    System.out.println("threads: " + Thread.currentThread().getThreadGroup().activeCount());
                    System.out.println("isAlive: " + main.isAlive());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }).start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("done");
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8546().run();
    }
}
