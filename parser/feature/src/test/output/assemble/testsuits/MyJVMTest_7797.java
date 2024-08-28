public class MyJVMTest_7797 {

    static boolean done = false;

    void run() {
        while (!done) {
            System.gc();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7797().run();
    }
}
