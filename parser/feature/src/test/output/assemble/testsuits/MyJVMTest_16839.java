import javax.swing.*;
import java.awt.*;

public class MyJVMTest_16839 {

    static JLabel toolTipLabel = new JLabel("tip");

    boolean isTooltipShowning() throws Exception {
        final boolean[] result = new boolean[1];
        SwingUtilities.invokeAndWait(new Runnable() {

            @Override
            public void run() {
                result[0] = toolTipLabel.isShowing();
            }
        });
        return result[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16839().run();
    }
}
