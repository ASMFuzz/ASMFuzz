import javax.swing.*;

public class MyJVMTest_17232 {

    void createGui() {
        JScrollPane sp = new JScrollPane();
        int listenerCount = sp.getPropertyChangeListeners().length;
        sp.updateUI();
        if (listenerCount != sp.getPropertyChangeListeners().length) {
            throw new RuntimeException("Listeners' leak");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17232().createGui();
    }
}
