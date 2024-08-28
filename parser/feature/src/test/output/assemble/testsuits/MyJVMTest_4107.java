import java.awt.*;
import javax.swing.*;

public class MyJVMTest_4107 {

    static int tickMinor = 4;

    static int tickMajor = 482349962;

    JSlider createSlider(int tickMinor, int tickMajor) {
        JSlider result = new JSlider();
        result.setPaintLabels(true);
        result.setPaintTicks(true);
        result.setSnapToTicks(true);
        result.setMinimum(0);
        result.setMaximum(12);
        result.setMinorTickSpacing(tickMinor);
        result.setMajorTickSpacing(tickMajor);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4107().createSlider(tickMinor, tickMajor));
    }
}
