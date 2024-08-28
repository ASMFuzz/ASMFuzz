import java.net.*;

public class MyJVMTest_17454 {

    static Class<?> expectedType = null;

    static InetAddress LOOPBACK = InetAddress.getLoopbackAddress();

    Class<?> assertLoopbackAddress(Class<?> expectedType) {
        if (!LOOPBACK.getClass().isAssignableFrom(expectedType))
            throw new RuntimeException("Expected " + expectedType + ", got " + LOOPBACK.getClass());
        return expectedType;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17454().assertLoopbackAddress(expectedType);
    }
}
