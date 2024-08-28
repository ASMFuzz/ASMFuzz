public class MyJVMTest_15802 {

    static int foundId = 0;

    static int expectedId = 7;

    int checkCreateFailureId(int foundId, int expectedId) {
        if (foundId != expectedId)
            throw new AssertionError("Wrong resource creation failed. Found ID " + foundId + " expected " + expectedId);
        return expectedId;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15802().checkCreateFailureId(foundId, expectedId);
    }
}
