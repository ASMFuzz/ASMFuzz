import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class MyJVMTest_2324 {

    static CaretEvent e = null;

    static boolean passed = false;

    CaretEvent caretUpdate(CaretEvent e) {
        passed = (e.getDot() == 3);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2324().caretUpdate(e);
    }
}
