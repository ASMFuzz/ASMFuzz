import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_11237 {

    static Component eParam1 = new Container();

    static int eParam2 = 711;

    static Component eParam3 = new Container();

    static Container eParam4 = new Container();

    static long eParam5 = 9223372036854775807L;

    static HierarchyEvent e = new HierarchyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean moved = false;

    static boolean ancestor_moved = false;

    HierarchyEvent ancestorMoved(HierarchyEvent e) {
        ancestor_moved = true;
        System.out.println("SMALL COMPONENT >>>>>" + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11237().ancestorMoved(e);
    }
}
