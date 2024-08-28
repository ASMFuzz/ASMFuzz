import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import sun.awt.*;

public class MyJVMTest_13321 {

    static JFrame f = null;

    static JTextField tf = null;

    void initGUI() {
        f = new JFrame("F");
        f.setBounds(100, 100, 200, 100);
        tf = new JTextField("Test");
        f.add(tf);
        f.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13321().initGUI();
    }
}
