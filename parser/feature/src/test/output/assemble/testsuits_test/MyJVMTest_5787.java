import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_5787 {

    static JScrollPane spane = null;

    static JScrollBar sbar = null;

    void run() {
        spane.requestFocus();
        sbar.setValue(sbar.getMaximum());
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5787().run();
    }
}
