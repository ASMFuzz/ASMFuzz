public class MyJVMTest_478 {

    static char[] data = { 'K', Character.MAX_VALUE, 'W', Character.MAX_VALUE, '!', Character.MIN_VALUE, Character.MAX_VALUE, Character.MAX_VALUE, Character.MIN_VALUE, Character.MIN_VALUE };

    static int pos = 3;

    static String text = "/ at start is bad";

    static Object lock = new Object();

    static boolean isCallbackInvoked = false;

    static Exception exception = null;

    int handleText(char[] data, int pos) {
        synchronized (lock) {
            if (!text.equals(new String(data)) || pos != 0) {
                exception = new RuntimeException("Test Failed: the data passed to ParserCallback.handleText() does not meet the expectation");
            }
            isCallbackInvoked = true;
            lock.notifyAll();
        }
        return pos;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_478().handleText(data, pos);
    }
}
