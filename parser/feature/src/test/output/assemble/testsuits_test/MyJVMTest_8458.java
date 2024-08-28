import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_8458 {

    static Component ceParam1 = new Container();

    static int ceParam2 = 135;

    static Component ceParam3 = new Container();

    static Container ceParam4 = new Container();

    static HierarchyEvent ce = new HierarchyEvent(ceParam1, ceParam2, ceParam3, ceParam4);

    static Component[] components = {null,null,null,null,null,null,null,null,null,null};

    static boolean[] ancestorMoved = {false,false,true,false,true,true,false,true,false,false};

    static int moveCount = 0;

    static boolean moveTriggered = false;

    static Object moveLock = new Object();

    static boolean check = false;

    HierarchyEvent ancestorMoved(HierarchyEvent ce) {
        if (check) {
            System.out.println("Moved " + ce.getComponent());
        }
        for (int i = 0; i < components.length; i++) {
            if (components[i].equals(ce.getComponent())) {
                ancestorMoved[i] = true;
                moveCount++;
                if (moveCount == components.length) {
                    moveTriggered = true;
                    synchronized (moveLock) {
                        try {
                            moveLock.notifyAll();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        return ce;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8458().ancestorMoved(ce);
    }
}
