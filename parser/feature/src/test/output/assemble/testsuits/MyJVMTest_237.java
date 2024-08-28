import java.io.ByteArrayInputStream;

public class MyJVMTest_237 {

    static String expectedHostAddress = "Aqob)VjE\\|";

    static String deserializedHostAddress = "TMDa;`jR&i";

    static boolean failed = false;

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
        new MyJVMTest_237().assertHostAddressEqual(expectedHostAddress, deserializedHostAddress);
    }
}
