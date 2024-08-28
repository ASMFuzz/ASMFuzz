import java.awt.Window;
import java.awt.Frame;

public class MyJVMTest_17165 {

    static Frame parentParam1Param1 = new Frame();

    static Window parentParam1 = new Window(parentParam1Param1);

    static GraphicsConfiguration parentParam2 = null;

    static Window parent = new Window(parentParam1, parentParam2);

    Window createWindow(Window parent) {
        Window window = new Window(parent);
        window.setSize(200, 200);
        window.setVisible(true);
        return window;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17165().createWindow(parent));
    }
}
