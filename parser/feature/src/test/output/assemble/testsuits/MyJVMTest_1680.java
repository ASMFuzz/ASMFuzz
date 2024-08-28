public class MyJVMTest_1680 {

    static boolean s_afterBothEvents = false;

    static Thread m_interruptee = null;

    static Object m_a = 0;

    void run() {
        synchronized (m_a) {
            System.out.println("inter synced on a");
            System.out.println("inter notifying main");
            m_a.notify();
            System.out.println("inter done notifying main");
            System.out.println("inter notifying main");
            m_interruptee.interrupt();
            s_afterBothEvents = true;
            System.out.println("inter done interrupting main");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1680().run();
    }
}
