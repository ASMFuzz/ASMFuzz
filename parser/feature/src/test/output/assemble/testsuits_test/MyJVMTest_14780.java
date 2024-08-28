import java.awt.*;
import java.applet.Applet;

public class MyJVMTest_14780 {

    static Frame frame = new Frame("PrintTest");

    void stop() {
        frame.setVisible(false);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14780().stop();
    }
}
