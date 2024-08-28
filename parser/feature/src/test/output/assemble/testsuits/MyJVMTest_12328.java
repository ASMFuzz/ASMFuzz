import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class MyJVMTest_12328 {

    static int axis = 0;

    float getAlignment(int axis) {
        return 0f;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12328().getAlignment(axis));
    }
}
