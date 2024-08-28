import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_12821 {

    static Component eParam1 = new Container();

    static int eParam2 = 145;

    static ComponentEvent e = new ComponentEvent(eParam1, eParam2);

    static boolean moved = false;

    ComponentEvent componentMoved(ComponentEvent e) {
        moved = true;
        System.out.println(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12821().componentMoved(e);
    }
}
