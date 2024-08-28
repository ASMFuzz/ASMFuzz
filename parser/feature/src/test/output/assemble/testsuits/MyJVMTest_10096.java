import javax.swing.*;

public class MyJVMTest_10096 {

    void run() {
        boolean expectedOpaqueValue = !"Nimbus".equals(UIManager.getLookAndFeel().getName());
        JSplitPane sp = new JSplitPane();
        if (sp.isOpaque() != expectedOpaqueValue) {
            throw new RuntimeException("JSplitPane has incorrect default opaque value");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10096().run();
    }
}
