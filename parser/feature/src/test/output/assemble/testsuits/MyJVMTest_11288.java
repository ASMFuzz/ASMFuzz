import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_11288 {

    static Frame frame = null, dummy = null;

    void run() {
        frame.setSize(new Dimension(frame.getSize().width + 10, frame.getSize().height + 10));
        frame.invalidate();
        frame.validate();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11288().run();
    }
}
