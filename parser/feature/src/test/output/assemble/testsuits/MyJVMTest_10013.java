public class MyJVMTest_10013 {

    static int i = 1;

    static boolean z = true;

    static char c = 'a';

    static short s = 3;

    static float f = 1.0f;

    static double d = 2.0;

    static Object l = 0;

    void synchonizedWeakReceiverTest() {
        this.notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10013().synchonizedWeakReceiverTest();
    }
}
