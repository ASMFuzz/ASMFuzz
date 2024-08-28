import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11182 {

    static String frameParam1 = "N(uC+^#SwB";

    static GraphicsConfiguration frameParam2 = null;

    static JFrame frame = new JFrame(frameParam1, frameParam2);

    JSlider test(JFrame frame) {
        JSlider hslider = new JSlider(JSlider.HORIZONTAL);
        hslider.setBackground(Color.DARK_GRAY);
        frame.getContentPane().add(hslider, BorderLayout.CENTER);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.pack();
        Insets insets = hslider.getInsets();
        if (hslider.getWidth() != 200 + insets.left + insets.right) {
            throw new RuntimeException("Horizontal slider width is wrong " + hslider.getWidth());
        }
        if (hslider.getHeight() != hslider.getMinimumSize().height) {
            throw new RuntimeException("Horizontal slider height is wrong " + hslider.getHeight());
        }
        frame.getContentPane().remove(hslider);
        JSlider vslider = new JSlider(JSlider.VERTICAL);
        frame.getContentPane().add(vslider);
        frame.pack();
        insets = vslider.getInsets();
        if (vslider.getWidth() != vslider.getMinimumSize().width) {
            throw new RuntimeException("Verical slider width is wrong " + vslider.getWidth());
        }
        if (vslider.getHeight() != 200 + insets.top + insets.bottom) {
            throw new RuntimeException("Verical slider height is wrong " + vslider.getHeight());
        }
        return hslider;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11182().test(frame);
    }
}
