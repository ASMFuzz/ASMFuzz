import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16893 {

    static Object[] array = { 0, 0, 0, 1196968998, -797905432, 2121048362, 743500949, 3, 8, 5 };

    static Object obj = 2;

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
        System.out.println(new MyJVMTest_16893().isPresent(array, obj));
    }
}
