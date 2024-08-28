import javax.swing.JFrame;

public class MyJVMTest_13152 {

    static JFrame instructionFrame = new JFrame();

    void disposeUI() {
        instructionFrame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13152().disposeUI();
    }
}
