import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_9343 {

    static int axis = 2;

    float getAlignment(int axis) {
        return 0.5f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9343().getAlignment(axis));
    }
}
