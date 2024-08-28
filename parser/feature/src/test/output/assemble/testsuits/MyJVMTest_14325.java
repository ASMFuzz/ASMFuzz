import java.awt.*;
import java.awt.geom.*;

public class MyJVMTest_14325 {

    static Frame backgroundFrame = null;

    static Frame window = null;

    static Robot robot = null;

    void run() {
        backgroundFrame.dispose();
        window.dispose();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14325().run();
    }
}
