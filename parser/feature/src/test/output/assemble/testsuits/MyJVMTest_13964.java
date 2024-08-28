import javax.swing.*;

public class MyJVMTest_13964 {

    static boolean vertical = true;

    static Boolean filled = false;

    static boolean enabled = false;

    static boolean inverted = true;

    static JComboBox cbThemes = new JComboBox();

    JSlider createSlider(boolean vertical, Boolean filled, boolean enabled, boolean inverted) {
        JSlider result = new JSlider(vertical ? SwingConstants.VERTICAL : SwingConstants.HORIZONTAL, 0, 100, 50);
        result.setMajorTickSpacing(20);
        result.setMinorTickSpacing(5);
        result.setPaintTicks(true);
        result.setPaintLabels(true);
        result.setEnabled(enabled);
        if (filled != null) {
            result.putClientProperty("JSlider.isFilled", filled);
        }
        result.setInverted(inverted);
        result.setToolTipText("<html>vertical = " + vertical + "<br>enabled = " + enabled + "<br>filled = " + filled + "<br>inverted = " + inverted + "</html>");
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13964().createSlider(vertical, filled, enabled, inverted));
    }
}
