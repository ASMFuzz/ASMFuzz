import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_3490 {

    static Component eParam1 = new Container();

    static int eParam2 = 99;

    static ComponentEvent e = new ComponentEvent(eParam1, eParam2);

    static boolean moved = false;

    ComponentEvent componentMoved(ComponentEvent e) {
        moved = true;
        System.out.println(e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3490().componentMoved(e);
    }
}
