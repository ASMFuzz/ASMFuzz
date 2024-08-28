import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;

public class MyJVMTest_16185 {

    static boolean passed = false;

    static JSlider slider = new JSlider(0, 10);

    Object getCellEditorValue() {
        return slider.getValue();
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16185().getCellEditorValue());
    }
}
