import javax.swing.*;

public class MyJVMTest_4108 {

    void run() {
        JFrame frame = new JFrame();
        JTable table = new JTable(new Object[][] { { "1", "2" }, { "3", "4" } }, new Object[] { "col1", "col2" });
        frame.getContentPane().add(new JScrollPane(table));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4108().run();
    }
}
