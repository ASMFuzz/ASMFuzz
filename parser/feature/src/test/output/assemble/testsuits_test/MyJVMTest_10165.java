import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_10165 {

    static Component eParam1 = new Container();

    static int eParam2 = 919;

    static Component eParam3 = new Container();

    static Container eParam4 = new Container();

    static HierarchyEvent e = new HierarchyEvent(eParam1, eParam2, eParam3, eParam4);

    static boolean resized = false;

    static boolean ancestor_resized = false;

    HierarchyEvent ancestorResized(HierarchyEvent e) {
        ancestor_resized = true;
        System.out.println("SMALL COMPONENT >>>>>" + e);
        return e;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10165().ancestorResized(e);
    }
}
