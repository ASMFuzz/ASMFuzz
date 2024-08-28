public class MyJVMTest_4821 {

    static boolean m_interruptSent = false;

    void run() {
        Object obj = new Object();
        try {
            System.out.println("interruptee spin waiting");
            while (!m_interruptSent) {
            }
            System.out.println("interruptee done spin waiting");
            synchronized (obj) {
                obj.wait();
            }
            System.out.println("interruptee done waiting");
            throw new Error("wait should have been interrupted");
        } catch (InterruptedException ie) {
            System.out.println("SUCCESS");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4821().run();
    }
}
