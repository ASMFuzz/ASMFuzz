import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_12068 {

    static Frame frame = null, dummy = null;

    void run() {
        frame.setLocation(frame.getLocation().x + 20, frame.getLocation().y + 20);
        frame.invalidate();
        frame.validate();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12068().run();
    }
}
