import java.awt.*;
import java.applet.Applet;

public class MyJVMTest_17329 {

    static Frame frame = new Frame("PrintTest");

    void destroy() {
        frame.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17329().destroy();
    }
}
