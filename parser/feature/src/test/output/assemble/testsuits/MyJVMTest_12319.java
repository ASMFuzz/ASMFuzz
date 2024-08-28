import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_12319 {

    static Component eParam1 = new Container();

    static int eParam2 = 164;

    static boolean eParam3 = true;

    static Component eParam4 = new Container();

    static FocusEvent e = new FocusEvent(eParam1, eParam2, eParam3, eParam4);

    static Object listener = new bug4927934();

    static boolean focusGained = false;

    FocusEvent focusGained(FocusEvent e) {
        focusGained = true;
        System.out.println("focusGained");
        listener.notifyAll();
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12319().focusGained(e);
    }
}
