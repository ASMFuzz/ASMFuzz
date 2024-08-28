import javax.swing.*;

public class MyJVMTest_6083 {

    static Object expectedObject = 6;

    static Object actualObject = 0;

    Object assertEquals(Object expectedObject, Object actualObject) {
        if (!expectedObject.equals(actualObject)) {
            throw new RuntimeException("Expected: " + expectedObject + " but was: " + actualObject);
        }
        return actualObject;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6083().assertEquals(expectedObject, actualObject);
    }
}
