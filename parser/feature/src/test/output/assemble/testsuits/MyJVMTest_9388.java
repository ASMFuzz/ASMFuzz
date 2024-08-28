import java.io.ByteArrayInputStream;

public class MyJVMTest_9388 {

    static String expectedHostAddress = "H*L_@9O&qz";

    static String deserializedHostAddress = "04dPey6';5";

    static boolean failed = true;

    String assertHostAddressEqual(String expectedHostAddress, String deserializedHostAddress) {
        System.err.println("Inet6AddressSerializationTest.assertHostAddressEqual:");
        if (expectedHostAddress == null) {
            if (deserializedHostAddress == null) {
            } else {
                System.err.println("Error checking " + " HostAddress, expected: " + expectedHostAddress + ", got: " + deserializedHostAddress);
                failed = true;
            }
        } else if (!expectedHostAddress.equals(deserializedHostAddress)) {
            System.err.println("Error checking " + " HostAddress, expected: " + expectedHostAddress + ", got: " + deserializedHostAddress);
            failed = true;
        } else {
            System.err.println("HostAddress equality " + " HostAddress, expected: " + expectedHostAddress + ", got: " + deserializedHostAddress);
        }
        return expectedHostAddress;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9388().assertHostAddressEqual(expectedHostAddress, deserializedHostAddress);
    }
}
