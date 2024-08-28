import javax.swing.*;
import java.awt.*;

public class MyJVMTest_15304 {

    static int increment = 918498408;

    static int testValue = 0;

    int increaseTestValue(int increment) {
        testValue += increment;
        return increment;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15304().increaseTestValue(increment);
    }
}
