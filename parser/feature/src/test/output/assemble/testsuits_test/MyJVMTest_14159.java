public class MyJVMTest_14159 {

    static boolean stopthreads = false;

    static SecurityManager sm = new SecurityManager();

    void run() {
        try {
            while (true) {
                if (stopthreads) {
                    return;
                }
                System.setSecurityManager(sm);
                System.setSecurityManager(null);
            }
        } catch (NullPointerException e) {
            stopthreads = true;
            return;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14159().run();
    }
}
