import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_18045 {

    static Component ceParam1 = new Container();

    static int ceParam2 = 243;

    static Component ceParam3 = new Container();

    static Container ceParam4 = new Container();

    static HierarchyEvent ce = new HierarchyEvent(ceParam1, ceParam2, ceParam3, ceParam4);

    static Component[] components = {null,null,null,null,null,null,null,null,null,null};

    static boolean[] ancestorMoved = {true,true,true,false,false,true,false,false,true,true};

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
        new MyJVMTest_18045().ancestorMoved(ce);
    }
}
