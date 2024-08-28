import java.io.ByteArrayInputStream;

public class MyJVMTest_589 {

    static int expectedScopeId = -1200083590;

    static int deserializedScopeId = -888953205;

    static boolean failed = false;

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
        new MyJVMTest_589().assertScopeIdEqual(expectedScopeId, deserializedScopeId);
    }
}
