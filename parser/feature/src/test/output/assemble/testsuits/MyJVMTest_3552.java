import javax.swing.*;

public class MyJVMTest_3552 {

    void createGui() {
        JLayer layer = new JLayer();
        layer.setGlassPane(null);
        layer.isOptimizedDrawingEnabled();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3552().createGui();
    }
}
