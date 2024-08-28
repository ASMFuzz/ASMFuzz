public class MyJVMTest_15852 {

    static Object m = 0;

    void run() {
        synchronized (m) {
            try {
                m.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15852().run();
    }
}
