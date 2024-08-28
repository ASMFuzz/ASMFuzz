import javax.swing.*;

public class MyJVMTest_14956 {

    void createAndShowGUI() {
        JFrame frame = new JFrame("bug8048506");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        PopupFactory factory = PopupFactory.getSharedInstance();
        Popup popup1 = factory.getPopup(frame, new JLabel("Popup with owner"), 100, 100);
        popup1.show();
        Popup popup2 = factory.getPopup(null, new JLabel("Popup without owner"), 200, 200);
        popup2.show();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14956().createAndShowGUI();
    }
}
