public class MyJVMTest_10209 {

    static int ZIP_ENTRY_NUM = 5;

    static byte[][] data = {{-63,41,-22,-12,-41,-81,-57,-77,27,105},{-95,-118,9,-14,-120,-103,75,68,-56,-58}};

    static int sleepMillis = -489093397;

    static boolean keepRunning = true;

    void shutDown() {
        keepRunning = false;
        notifyAll();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10209().shutDown();
    }
}
