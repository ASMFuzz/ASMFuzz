import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_13515 {

    static Object evParam1 = 0;

    static int evParam2 = 375;

    static String evParam3 = "'t-~Iwz,hX";

    static long evParam4 = 0;

    static int evParam5 = 245;

    static ActionEvent ev = new ActionEvent(evParam1, evParam2, evParam3, evParam4, evParam5);

    static JRootPane rootPane = null;

    void run() {
        JFrame frame = new JFrame();
        final JButton button = new JButton();
        frame.add(button);
        button.addActionListener(new ActionListener() {

            public ActionEvent actionPerformed(ActionEvent ev) {
                if (button.isValid()) {
                    button.invalidate();
                } else {
                    button.revalidate();
                }
                return ev;
            }
        });
        rootPane = frame.getRootPane();
        frame.pack();
        frame.setVisible(true);
        if (!frame.isValid()) {
            throw new RuntimeException("setVisible(true) failed to validate the frame");
        }
        button.invalidate();
        if (rootPane.isValid()) {
            throw new RuntimeException("invalidate() failed to invalidate the root pane");
        }
        if (!frame.isValid()) {
            throw new RuntimeException("invalidate() invalidated the frame");
        }
        button.revalidate();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13515().actionPerformed(ev);
    }
}
