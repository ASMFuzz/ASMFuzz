import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_14722 {

    static Object eventParam1 = 3;

    static int eventParam2 = 313;

    static String eventParam3 = "W{C#'L`]TL";

    static ActionEvent event = new ActionEvent(eventParam1, eventParam2, eventParam3);

    void pass() {
        pass = true;
        notifyAll();
    }

    static Test test = new Test();

    static JFrame fr = null;

    static boolean pass = true;

    JFrame createTestFrame(String name, Component topComponent, String instructions, int instrHeight) {
        final String PASS = "Pass";
        final String FAIL = "Fail";
        JFrame frame = new JFrame(name);
        frame.setLayout(new BorderLayout());
        JPanel testButtonsPanel = new JPanel();
        testButtonsPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 20));
        ActionListener btnAL = new ActionListener() {

            public ActionEvent actionPerformed(ActionEvent event) {
                switch(event.getActionCommand()) {
                    case PASS:
                        pass();
                        break;
                    default:
                        throw new RuntimeException("Test failed.");
                }
                return event;
            }
        };
        JButton passBtn = new JButton(PASS);
        passBtn.addActionListener(btnAL);
        passBtn.setActionCommand(PASS);
        JButton failBtn = new JButton(FAIL);
        failBtn.addActionListener(btnAL);
        failBtn.setActionCommand(FAIL);
        testButtonsPanel.add(BorderLayout.WEST, passBtn);
        testButtonsPanel.add(BorderLayout.EAST, failBtn);
        JTextArea instrText = new JTextArea();
        instrText.setLineWrap(true);
        instrText.setEditable(false);
        JScrollPane instrScrollPane = new JScrollPane(instrText);
        instrScrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE, instrHeight));
        instrText.append(instructions);
        JPanel servicePanel = new JPanel();
        servicePanel.setLayout(new BorderLayout());
        if (topComponent == null) {
            frame.add(BorderLayout.CENTER, instrScrollPane);
        } else {
            servicePanel.add(BorderLayout.CENTER, instrScrollPane);
            frame.add(BorderLayout.CENTER, topComponent);
        }
        servicePanel.add(BorderLayout.SOUTH, testButtonsPanel);
        frame.add(BorderLayout.SOUTH, servicePanel);
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14722().actionPerformed(event);
    }
}
