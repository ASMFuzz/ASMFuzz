import java.awt.*;
import javax.swing.*;

public class MyJVMTest_12107 {

    static int cols = 949924296;

    static int bigCol = -1;

    static int bigRow = -1;

    JComponent createSeparator() {
        return new JLabel();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12107().createSeparator());
    }
}
