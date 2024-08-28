public class MyJVMTest_8955 {

    static Thread mainThread = null;

    static boolean testPassed = true;

    static boolean testGeneratedInterrupt = true;

    void pass() {
        testPassed = true;
        testGeneratedInterrupt = true;
        mainThread.interrupt();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8955().pass();
    }
}
