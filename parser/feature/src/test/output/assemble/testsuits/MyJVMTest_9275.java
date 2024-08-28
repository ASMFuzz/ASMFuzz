public class MyJVMTest_9275 {

    static int INTERNAL_TIMEOUT = 240;

    static boolean done = false;

    void run() {
        try {
            Thread.sleep(INTERNAL_TIMEOUT * 1000);
        } catch (InterruptedException ex) {
        }
        done = true;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9275().run();
    }
}
