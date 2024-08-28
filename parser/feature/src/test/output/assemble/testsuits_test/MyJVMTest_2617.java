import javax.swing.*;
import java.awt.*;

public class MyJVMTest_2617 {

    static Object o1 = 0;

    static Object o2 = 1;

    Object check(Object o1, Object o2) {
        if (o1 != o2) {
            throw new RuntimeException("Test failed");
        }
        return o2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2617().check(o1, o2);
    }
}
