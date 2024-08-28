import java.awt.Window;
import java.awt.Frame;

public class MyJVMTest_7619 {

    static String parentParam1Param1 = ".mcZy\\_[4E";

    static GraphicsConfiguration parentParam1Param2 = null;

    static Frame parentParam1 = new Frame(parentParam1Param1, parentParam1Param2);

    static Window parent = new Window(parentParam1);

    Window createWindow(Window parent) {
        Window window = new Window(parent);
        window.setSize(200, 200);
        window.setVisible(true);
        return window;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7619().createWindow(parent));
    }
}
