import java.net.*;

public class MyJVMTest_14294 {

    static Class<?> expectedType = null;

    Class<?> assertAnyLocalAddress(Class<?> expectedType) {
        InetAddress anyAddr = (new InetSocketAddress(0)).getAddress();
        if (!anyAddr.getClass().isAssignableFrom(expectedType))
            throw new RuntimeException("Expected " + expectedType + ", got " + anyAddr.getClass());
        return expectedType;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14294().assertAnyLocalAddress(expectedType);
    }
}
