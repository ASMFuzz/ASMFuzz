public class MyJVMTest_14309 {

    static String s = "w~O%A7wSD~";

    static Object m_a = -118751217;

    static Object m_b = 2;

    static Thread m_interruptee = null;

    String Print(String s) {
        synchronized (System.out) {
            System.out.print(System.currentTimeMillis() + ": ");
            System.out.println(s);
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14309().Print(s);
    }
}
