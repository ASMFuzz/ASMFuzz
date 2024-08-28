import java.awt.Frame;

public class MyJVMTest_14215 {

    static Frame mainFrame = null;

    static Frame instructionFrame = null;

    void cleanUp() {
        mainFrame.dispose();
        instructionFrame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14215().cleanUp();
    }
}
