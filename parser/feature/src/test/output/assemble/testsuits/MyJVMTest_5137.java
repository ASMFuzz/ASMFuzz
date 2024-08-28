import javax.swing.JFrame;

public class MyJVMTest_5137 {

    static JFrame frame = null;

    void disposeUI() {
        frame.setVisible(false);
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5137().disposeUI();
    }
}
