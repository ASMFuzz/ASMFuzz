import javax.swing.*;
import java.awt.*;

public class MyJVMTest_5857 {

    static int increment = 1;

    static int testValue = 5;

    int increaseTestValue(int increment) {
        testValue += increment;
        return increment;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5857().increaseTestValue(increment);
    }
}
