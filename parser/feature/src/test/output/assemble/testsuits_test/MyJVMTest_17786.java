import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import java.applet.Applet;

public class MyJVMTest_17786 {

    static Frame frame = new Frame();

    void init() {
        frame.setTitle("Drop target frame");
        frame.setLocation(200, 200);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17786().init();
    }
}
