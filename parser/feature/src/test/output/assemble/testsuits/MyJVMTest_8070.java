import java.awt.*;
import javax.swing.*;
import java.util.Arrays;

public class MyJVMTest_8070 {

    static Object[] expectedArray = { -864055625, 0, 1, 0, 9, 1, 0, 5, 2, 4 };

    static Object[] actualArray = { 0, 1, 7, 9, 2, 8, 7, -1614314068, 0, 8 };

    Object[] assertEquals(Object[] expectedArray, Object[] actualArray) {
        if (!Arrays.equals(expectedArray, actualArray)) {
            throw new RuntimeException("Expected: " + Arrays.toString(expectedArray) + " but was: " + Arrays.toString(actualArray));
        }
        return actualArray;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8070().assertEquals(expectedArray, actualArray);
    }
}
