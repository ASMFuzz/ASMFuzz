import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12801 {

    static Robot robot = null;

    static Toolkit tk = Toolkit.getDefaultToolkit();

    static Choice choice = new Choice();

    static boolean indexChanged = false;

    static int INITIAL_ITEM = 99;

    static boolean stateChanged = true;

    void checkSelectedIndex() {
        if (choice.getSelectedIndex() != INITIAL_ITEM) {
            System.out.println("choice.getSelectedIndex = " + choice.getSelectedIndex());
            indexChanged = true;
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12801().checkSelectedIndex();
    }
}
