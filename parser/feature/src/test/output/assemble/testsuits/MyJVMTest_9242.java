import javax.swing.*;
import java.awt.*;

public class MyJVMTest_9242 {

    static int n = 0;

    static JFrame frame = null;

    static JSlider slider = null;

    void run() {
        frame = new JFrame();
        DefaultBoundedRangeModel sliderModel = new DefaultBoundedRangeModel() {

            public int setValue(int n) {
                return n;
            }
        };
        slider = new JSlider(sliderModel);
        frame.getContentPane().add(slider);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9242().setValue(n);
    }
}
