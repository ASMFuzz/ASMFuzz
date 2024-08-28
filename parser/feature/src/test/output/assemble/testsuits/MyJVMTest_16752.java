import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16752 {

    static int key = 8;

    static Robot robot = null;

    int hitKey(int key) {
        System.out.println("key " + key + " pressed");
        robot.keyPress(key);
        robot.keyRelease(key);
        return key;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16752().hitKey(key);
    }
}
