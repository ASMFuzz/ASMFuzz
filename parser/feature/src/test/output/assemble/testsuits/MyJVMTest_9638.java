public class MyJVMTest_9638 {

    static char[] data = { Character.MAX_VALUE, '0', Character.MIN_VALUE, Character.MAX_VALUE, 'H', Character.MIN_VALUE, Character.MAX_VALUE, 'Q', Character.MAX_VALUE, Character.MAX_VALUE };

    static int pos = 0;

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
        new MyJVMTest_9638().handleText(data, pos);
    }
}
