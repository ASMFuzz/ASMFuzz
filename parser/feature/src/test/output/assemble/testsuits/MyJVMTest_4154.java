import javax.swing.*;
import java.awt.event.*;

public class MyJVMTest_4154 {

    static Object evParam1 = 5;

    static int evParam2 = 777;

    static String evParam3 = "-!ciK;4S s";

    static ActionEvent ev = new ActionEvent(evParam1, evParam2, evParam3);

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
        new MyJVMTest_4154().actionPerformed(ev);
    }
}
