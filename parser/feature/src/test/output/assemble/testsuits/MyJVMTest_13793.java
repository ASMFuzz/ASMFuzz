import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.dnd.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.applet.Applet;

public class MyJVMTest_13793 {

    static Frame frame = new Frame("Target Frame");

    void init() {
        frame.setTitle("Test frame");
        frame.setBounds(100, 100, 150, 150);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13793().init();
    }
}
