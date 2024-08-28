import javax.swing.*;
import java.awt.*;

public class MyJVMTest_15631 {

    static String labelText = "RsO|6u1~pt";

    static SpinnerModel spinnerParam1 = null;

    static JSpinner spinner = new JSpinner(spinnerParam1);

    static JPanel labelPanel = null;

    static JPanel spinnerPanel = null;

    JPanel addSpinner(String labelText, JSpinner spinner) {
        JLabel label = new JLabel(labelText);
        label.setHorizontalAlignment(SwingConstants.TRAILING);
        labelPanel.add(label);
        JPanel flowPanel = new JPanel();
        flowPanel.setLayout(new FlowLayout(FlowLayout.LEADING, 5, 1));
        flowPanel.add(spinner);
        spinnerPanel.add(flowPanel);
        return flowPanel;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15631().addSpinner(labelText, spinner);
    }
}
