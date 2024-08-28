import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_16045 {

    static JMenu fileMenu = null;

    void run() {
        new NonOpaquePopupMenuTest();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16045().run();
    }
}
