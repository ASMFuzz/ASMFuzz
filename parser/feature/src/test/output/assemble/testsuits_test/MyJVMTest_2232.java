public class MyJVMTest_2232 {

    static boolean isImageStarted = false;

    static boolean isImageComplete = false;

    void checkResults() {
        if (isImageStarted && !isImageComplete) {
            throw new RuntimeException("The imageCompleted was not called." + " Test failed.");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2232().checkResults();
    }
}
