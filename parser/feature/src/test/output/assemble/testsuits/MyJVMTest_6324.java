public class MyJVMTest_6324 {

    static int foundId = 328291470;

    static int expectedId = 0;

    int checkCreateFailureId(int foundId, int expectedId) {
        if (foundId != expectedId)
            throw new AssertionError("Wrong resource creation failed. Found ID " + foundId + " expected " + expectedId);
        return expectedId;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6324().checkCreateFailureId(foundId, expectedId);
    }
}
