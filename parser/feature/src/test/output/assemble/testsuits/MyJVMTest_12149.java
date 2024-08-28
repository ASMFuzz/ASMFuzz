import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_12149 {

    static Object eParam1 = 3;

    static ChangeEvent e = new ChangeEvent(eParam1);

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    ChangeEvent stateChanged(ChangeEvent e) {
        if (!slider.getValueIsAdjusting()) {
            passed = slider.getValue() <= 5;
        }
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12149().stateChanged(e);
    }
}
