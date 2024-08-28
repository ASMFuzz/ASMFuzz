import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7059 {

    static Component EVTParam1 = new Container();

    static int EVTParam2 = 829;

    static long EVTParam3 = -9223372036854775808L;

    static int EVTParam4 = 851;

    static int EVTParam5 = 330;

    static KeyEvent EVT = new KeyEvent(EVTParam1, EVTParam2, EVTParam3, EVTParam4, EVTParam5);

    static JFrame firstFrame = null;

    static JFrame secondFrame = null;

    static JTextField mainFrameTf1 = null;

    static JTextField mainFrameTf2 = null;

    static JTextField secondFrameTf = null;

    void createWindows() {
        firstFrame = new JFrame("Frame");
        firstFrame.setLayout(new FlowLayout());
        firstFrame.setPreferredSize(new Dimension(600, 100));
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("File");
        JMenuItem item = new JMenuItem("Save");
        mainFrameTf1 = new JTextField(10);
        mainFrameTf2 = new JTextField(10);
        mainFrameTf1.addKeyListener(new KeyAdapter() {

            public KeyEvent keyPressed(KeyEvent EVT) {
                if (EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z') {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                return EVT;
            }
        });
        menu.add(item);
        bar.add(menu);
        firstFrame.setJMenuBar(bar);
        firstFrame.add(mainFrameTf1);
        firstFrame.add(mainFrameTf2);
        firstFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        firstFrame.pack();
        secondFrame = new JFrame("Frame 2");
        secondFrame.setPreferredSize(new Dimension(600, 100));
        secondFrame.setLocation(0, 150);
        secondFrameTf = new JTextField(20);
        secondFrame.add(secondFrameTf);
        secondFrame.pack();
        secondFrame.setVisible(true);
        firstFrame.setVisible(true);
        mainFrameTf1.requestFocus();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7059().keyPressed(EVT);
    }
}
