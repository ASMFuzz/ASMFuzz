public class MyJVMTest_15649 {

    static Thread m_interruptee = null;

    static Object m_a = -1559552658;

    void run() {
        synchronized (m_a) {
            System.out.println("inter synced on a");
            System.out.println("inter notifying main");
            m_a.notify();
            System.out.println("inter done notifying main");
            System.out.println("inter notifying main");
            m_interruptee.interrupt();
            System.out.println("inter done interrupting main");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15649().run();
    }
}
