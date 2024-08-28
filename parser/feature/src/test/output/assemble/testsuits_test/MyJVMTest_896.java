import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_896 {

    static Component eParam1 = new Container();

    static int eParam2 = 89;

    static Component eParam3 = new Container();

    static Container eParam4 = new Container();

    static long eParam5 = 0;

    static HierarchyEvent e = new HierarchyEvent(eParam1, eParam2, eParam3, eParam4, eParam5);

    static boolean moved = false;

    static boolean resized = false;

    static boolean ancestor_moved = false;

    static boolean ancestor_resized = false;

    void run() {
        JFrame parentWindow = new JFrame("JFrame 1");
        JButton component = new JButton("JButton 1");
        ;
        JButton smallButton = new JButton("Small Button");
        smallButton.addHierarchyBoundsListener(new HierarchyBoundsAdapter() {

            public void ancestorMoved(HierarchyEvent e) {
                ancestor_moved = true;
                System.out.println("SMALL COMPONENT >>>>>" + e);
            }

            public HierarchyEvent ancestorResized(HierarchyEvent e) {
                ancestor_resized = true;
                System.out.println("SMALL COMPONENT >>>>>" + e);
                return e;
            }
        });
        parentWindow.add(component);
        component.add(smallButton);
        component.setSize(100, 100);
        component.setLocation(100, 100);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_896().ancestorResized(e);
    }
}
