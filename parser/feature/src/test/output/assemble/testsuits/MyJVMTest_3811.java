import javax.swing.JFrame;

public class MyJVMTest_3811 {

    static JFrame instructionFrame = new JFrame();

    void disposeUI() {
        instructionFrame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3811().disposeUI();
    }
}
