import java.io.ByteArrayInputStream;

public class MyJVMTest_16949 {

    static String expectedHostName = "Rg'h?,[=$\"";

    static String deserializedHostName = "^&7~m?D^F1";

    static boolean failed = false;

    String assertHostNameEqual(String expectedHostName, String deserializedHostName) {
        System.err.println("Inet6AddressSerializationTest.assertHostNameEqual:");
        if (expectedHostName == null) {
            if (deserializedHostName == null) {
            } else {
                System.err.println("Error checking " + " HostName, expected:" + expectedHostName + ", got :" + deserializedHostName);
                failed = true;
            }
        } else if (!expectedHostName.equals(deserializedHostName)) {
            System.err.println("Error checking " + " HostName, expected:" + expectedHostName + ", got :" + deserializedHostName);
            failed = true;
        } else {
            System.err.println("HostName equality " + " HostName, expected:" + expectedHostName + ", got :" + deserializedHostName);
        }
        return expectedHostName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16949().assertHostNameEqual(expectedHostName, deserializedHostName);
    }
}
