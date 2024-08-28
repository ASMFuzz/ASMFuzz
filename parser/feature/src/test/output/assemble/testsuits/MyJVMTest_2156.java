import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_2156 {

    static Object eventParam1 = 0;

    static int eventParam2 = 69;

    static String eventParam3 = "U%Y*\\37j&p";

    static long eventParam4 = 0;

    static int eventParam5 = 735;

    static ActionEvent event = new ActionEvent(eventParam1, eventParam2, eventParam3, eventParam4, eventParam5);

    void pass() {
        pass = true;
        notifyAll();
    }

    static Test test = new Test();

    static boolean pass = false;

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
        servicePanel.add(BorderLayout.CENTER, instrScrollPane);
        servicePanel.add(BorderLayout.SOUTH, testButtonsPanel);
        frame.add(BorderLayout.SOUTH, servicePanel);
        frame.add(BorderLayout.CENTER, topComponent);
        return frame;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2156().actionPerformed(event);
    }
}
