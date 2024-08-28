import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class MyJVMTest_17639 {

    static Object[] expectedArray = { 2, 6, 0, 2, 6, 5, 0, 0, 8, -1741807971 };

    static Object[] actualArray = { 6, 0, 0, 0, 5, 0, 9, 0, 4, 8 };

    Object[] assertEquals(Object[] expectedArray, Object[] actualArray) {
        if (!Arrays.equals(expectedArray, actualArray)) {
            throw new RuntimeException("Expected: " + Arrays.toString(expectedArray) + " but was: " + Arrays.toString(actualArray));
        }
        return actualArray;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17639().assertEquals(expectedArray, actualArray);
    }
}
