import javax.swing.*;

public class MyJVMTest_12886 {

    void createGui() {
        JLayer layer = new JLayer();
        layer.setGlassPane(null);
        layer.isOptimizedDrawingEnabled();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12886().createGui();
    }
}
