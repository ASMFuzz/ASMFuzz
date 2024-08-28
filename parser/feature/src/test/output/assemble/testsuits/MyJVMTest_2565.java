import javax.swing.*;
import java.awt.*;

public class MyJVMTest_2565 {

    static JMenu menu1 = null;

    static JMenu menu2 = null;

    void run() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar bar = new JMenuBar();
        menu1 = new JMenu("Menu1");
        menu1.add(new JMenuItem("item"));
        bar.add(menu1);
        menu2 = new JMenu("Menu2");
        menu2.add(new JMenuItem("item"));
        menu2.add(new JMenuItem("item"));
        bar.add(menu2);
        frame.setJMenuBar(bar);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2565().run();
    }
}
