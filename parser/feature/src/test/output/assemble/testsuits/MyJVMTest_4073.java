public class MyJVMTest_4073 {

    static int numCreationFailuresDetected = -1692486794;

    int checkForSingleCreationFailure(int numCreationFailuresDetected) {
        if (numCreationFailuresDetected != 1)
            throw new AssertionError("Wrong number of creation failures: " + numCreationFailuresDetected);
        return numCreationFailuresDetected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4073().checkForSingleCreationFailure(numCreationFailuresDetected);
    }
}
