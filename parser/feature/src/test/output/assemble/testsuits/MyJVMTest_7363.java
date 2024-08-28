import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7363 {

    static Object[] array = { 9, 0, 3, 0, 9, 9, 4, 1, 1, 6 };

    static Object obj = 1;

    boolean isPresent(Object[] array, Object obj) {
        if (array == null || array.length == 0 || obj == null) {
            return false;
        }
        for (int i = 0; i < array.length; i++) {
            if (obj.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7363().isPresent(array, obj));
    }
}
