import java.io.ByteArrayInputStream;

public class MyJVMTest_9755 {

    static int expectedScopeId = -1336058971;

    static int deserializedScopeId = 8;

    static boolean failed = true;

    int assertScopeIdEqual(int expectedScopeId, int deserializedScopeId) {
        System.err.println("Inet6AddressSerializationTest.assertScopeIdEqual:");
        if (expectedScopeId != deserializedScopeId) {
            System.err.println("Error checking " + " ScopeId, expected:" + expectedScopeId + ", got: " + deserializedScopeId);
            failed = true;
        } else {
            System.err.println("ScopeId equality " + " ScopeId, expected: " + expectedScopeId + ", got: " + deserializedScopeId);
        }
        return deserializedScopeId;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9755().assertScopeIdEqual(expectedScopeId, deserializedScopeId);
    }
}
