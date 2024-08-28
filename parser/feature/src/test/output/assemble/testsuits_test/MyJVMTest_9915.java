import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.JComponent;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class MyJVMTest_9915 {

    static String inputParam1Param1 = "xgjpHBW9Qo";

    static boolean inputParam1Param2 = true;

    static boolean inputParam1Param3 = false;

    static JInternalFrame inputParam1 = new JInternalFrame(inputParam1Param1, inputParam1Param2, inputParam1Param3);

    static JComponent input = new BasicInternalFrameTitlePane(inputParam1);

    static boolean success = true;

    static JTextField field2 = null;

    boolean verifyTarget(JComponent input) {
        success = input == field2;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9915().verifyTarget(input));
    }
}
