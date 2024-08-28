import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_2853 {

    static Object eParam1 = 6;

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
        new MyJVMTest_2853().stateChanged(e);
    }
}
