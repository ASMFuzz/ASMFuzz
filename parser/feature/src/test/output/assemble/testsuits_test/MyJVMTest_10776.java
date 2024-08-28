import java.awt.Frame;

public class MyJVMTest_10776 {

    static Frame backFrame = null;

    static Frame frontFrame = null;

    void constructTestUI() {
        backFrame = new Frame();
        backFrame.setBounds(100, 100, 100, 100);
        backFrame.setResizable(false);
        backFrame.setVisible(true);
        frontFrame = new Frame();
        frontFrame.setBounds(120, 120, 60, 60);
        frontFrame.setResizable(false);
        frontFrame.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10776().constructTestUI();
    }
}
