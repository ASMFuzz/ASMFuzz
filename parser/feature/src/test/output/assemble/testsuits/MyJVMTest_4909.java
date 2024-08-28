public class MyJVMTest_4909 {

    static String s = "+F|ouT!->0";

    static Object m_a = 6;

    static Object m_b = -304696975;

    static Thread m_interruptee = null;

    String Print(String s) {
        synchronized (System.out) {
            System.out.print(System.currentTimeMillis() + ": ");
            System.out.println(s);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4909().Print(s);
    }
}
