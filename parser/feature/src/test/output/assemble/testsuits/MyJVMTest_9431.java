import javax.swing.*;

public class MyJVMTest_9431 {

    void createGui() {
        JPopupMenu menu = new JPopupMenu();
        menu.add(new JMenuItem());
        menu.setVisible(true);
        menu.setVisible(false);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9431().createGui();
    }
}
