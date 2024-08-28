import javax.swing.*;

public class MyJVMTest_703 {

    static boolean vertical = true;

    static boolean enabled = false;

    static boolean filled = true;

    static boolean inverted = false;

    JSlider createSlider(boolean vertical, boolean enabled, boolean filled, boolean inverted) {
        JSlider result = new JSlider(vertical ? SwingConstants.VERTICAL : SwingConstants.HORIZONTAL, 0, 10, 5);
        result.setEnabled(enabled);
        result.putClientProperty("JSlider.isFilled", filled);
        result.setInverted(inverted);
        result.setToolTipText("<html>vertical = " + vertical + "<br>enabled = " + enabled + "<br>filled = " + filled + "<br>inverted = " + inverted + "</html>");
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_703().createSlider(vertical, enabled, filled, inverted));
    }
}
