import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyJVMTest_17915 {

    static int[] array = { 969030545, 0, -462979745, 0, -1818649606, 4, 1813646726, 1, 3, -886807277 };

    static Object obj = 6;

    Object checkNullAndPutValuesToArray(int[] array, Object obj) {
        if (obj == null) {
            throw new RuntimeException("Test failed. The array obtained via reflection is " + obj);
        }
        for (int i = 0; i < Array.getLength(obj); i++) {
            System.out.println("Test (Reflection): " + Array.getInt(obj, i));
            array[i] = Array.getInt(obj, i);
        }
        return obj;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17915().checkNullAndPutValuesToArray(array, obj);
    }
}
