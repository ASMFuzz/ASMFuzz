import javax.swing.*;
import java.awt.*;
import javax.swing.plaf.basic.JComponent;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

public class MyJVMTest_737 {

    static String inputParam1Param1 = "W2Tui%]CbA";

    static boolean inputParam1Param2 = false;

    static boolean inputParam1Param3 = true;

    static boolean inputParam1Param4 = true;

    static boolean inputParam1Param5 = false;

    static JInternalFrame inputParam1 = new JInternalFrame(inputParam1Param1, inputParam1Param2, inputParam1Param3, inputParam1Param4, inputParam1Param5);

    static JComponent input = new BasicInternalFrameTitlePane(inputParam1);

    static boolean success = false;

    static JTextField field2 = null;

    boolean verifyTarget(JComponent input) {
        success = input == field2;
        return false;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_737().verifyTarget(input));
    }
}
