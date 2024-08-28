public class MyJVMTest_6242 {

    static Thread main = null;

    void run() {
        while (true) {
            System.out.println("threads: " + Thread.currentThread().getThreadGroup().activeCount());
            System.out.println("isAlive: " + main.isAlive());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6242().run();
    }
}
