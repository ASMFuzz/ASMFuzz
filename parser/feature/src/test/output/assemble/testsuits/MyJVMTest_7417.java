import java.io.ByteArrayInputStream;

public class MyJVMTest_7417 {

    static String expectedHostName = "@m%2B]Wd5f";

    static String deserializedHostName = "u0t>-bCJ\"{";

    static boolean failed = true;

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
        new MyJVMTest_7417().assertHostNameEqual(expectedHostName, deserializedHostName);
    }
}
