import javax.swing.*;

public class MyJVMTest_4448 {

    void run() {
        boolean expectedOpaqueValue = !("Nimbus".equals(UIManager.getLookAndFeel().getName()) || UIManager.getLookAndFeel().getName().contains("GTK"));
        JSplitPane sp = new JSplitPane();
        System.out.println("sp.isOpaque " + sp.isOpaque());
        if (sp.isOpaque() != expectedOpaqueValue) {
            throw new RuntimeException("JSplitPane has incorrect default opaque value");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4448().run();
    }
}
