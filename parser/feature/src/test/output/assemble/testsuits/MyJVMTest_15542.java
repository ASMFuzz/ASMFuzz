import javax.swing.*;

public class MyJVMTest_15542 {

    static Object expectedObject = 3;

    static Object actualObject = 0;

    Object assertEquals(Object expectedObject, Object actualObject) {
        if (!expectedObject.equals(actualObject)) {
            throw new RuntimeException("Expected: " + expectedObject + " but was: " + actualObject);
        }
        return actualObject;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15542().assertEquals(expectedObject, actualObject);
    }
}
