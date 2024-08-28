import java.awt.GraphicsEnvironment;
import java.beans.Beans;

public class MyJVMTest_18019 {

    void run() {
        if (Beans.isGuiAvailable() == GraphicsEnvironment.isHeadless()) {
            throw new Error("shared GuiAvailable property");
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_18019().run();
    }
}
