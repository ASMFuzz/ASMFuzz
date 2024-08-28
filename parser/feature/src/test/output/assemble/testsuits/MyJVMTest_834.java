public class MyJVMTest_834 {

    static int i = 1;

    static boolean z = true;

    static char c = 'a';

    static short s = 3;

    static float f = 1.0f;

    static double d = 2.0;

    static Object l = -1276498516;

    void synchonizedWeakReceiverTest() {
        this.notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_834().synchonizedWeakReceiverTest();
    }
}
