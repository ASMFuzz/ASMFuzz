import java.awt.*;
import javax.swing.*;

public class MyJVMTest_2813 {

    static int cols = 0;

    static int bigCol = -1;

    static int bigRow = -1;

    JComponent createSeparator() {
        return new JLabel();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2813().createSeparator());
    }
}
