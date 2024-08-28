public class MyJVMTest_13431 {

    static int numCreationFailuresDetected = 6;

    int checkForSingleCreationFailure(int numCreationFailuresDetected) {
        if (numCreationFailuresDetected != 1)
            throw new AssertionError("Wrong number of creation failures: " + numCreationFailuresDetected);
        return numCreationFailuresDetected;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13431().checkForSingleCreationFailure(numCreationFailuresDetected);
    }
}
