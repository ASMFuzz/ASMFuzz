import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_2804 {

    static Component eParam1 = new Container();

    static int eParam2 = 691;

    static ComponentEvent e = new ComponentEvent(eParam1, eParam2);

    static boolean resized = false;

    ComponentEvent componentResized(ComponentEvent e) {
        resized = true;
        System.out.println(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2804().componentResized(e);
    }
}
