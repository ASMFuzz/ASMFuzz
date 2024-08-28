import javax.swing.*;
import java.awt.*;

public class MyJVMTest_11829 {

    static JFrame frame = null;

    static JTextArea textarea = null;

    static JScrollPane scrollPane = null;

    void run() {
        textarea = new JTextArea("before###1###\nbefore###2###\nbefore###3###\nbefore###4###\nbefore###5###\n");
        scrollPane = new JScrollPane(textarea);
        scrollPane.setPreferredSize(new Dimension(100, 50));
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        frame.setSize(200, 200);
        frame.add(scrollPane, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11829().run();
    }
}
