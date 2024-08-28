import javax.swing.*;

public class MyJVMTest_17637 {

    void setup(JFrame frame) {
        JDesktopPane desktop = new JDesktopPane();
        frame.setContentPane(desktop);
        frame1 = new JInternalFrame("1", true, true, true, true);
        frame1.setBounds(40, 40, 300, 200);
        frame1.setVisible(true);
        desktop.add(frame1);
        frame2 = new JInternalFrame("2", true, true, true, true);
        frame2.setBounds(20, 20, 300, 200);
        frame2.setVisible(true);
        desktop.add(frame2);
        frame.setSize(500, 400);
        frame.setVisible(true);
    }

    static JFrame frame = null;

    static JInternalFrame frame1 = null;

    static JInternalFrame frame2 = null;

    void run() {
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setup(frame);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17637().run();
    }
}
