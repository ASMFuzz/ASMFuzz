import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_1855 {

    static Component ceParam1 = new Container();

    static int ceParam2 = 863;

    static Component ceParam3 = new Container();

    static Container ceParam4 = new Container();

    static HierarchyEvent ce = new HierarchyEvent(ceParam1, ceParam2, ceParam3, ceParam4);

    static Frame frame = null, dummy = null;

    static Component[] components = {null,null,null,null,null,null,null,null,null,null};

    static boolean[] ancestorResized = {true,true,true,true,true,true,false,false,true,true};

    static int resizeCount = 0;

    static boolean passed = true;

    static boolean resizeTriggered = false;

    static Object resizeLock = new Object();

    static boolean check = false;

    HierarchyEvent ancestorResized(HierarchyEvent ce) {
        if (check) {
            System.out.println("Resized " + ce.getComponent());
        }
        for (int i = 0; i < components.length; i++) {
            if (components[i].equals(ce.getComponent())) {
                if (!frame.equals(ce.getChanged()) || ce.getChangedParent() != null) {
                    System.err.println("FAIL: Invalid value of HierarchyEvent.getXXX");
                    System.err.println("ce.getChanged() : " + ce.getChanged());
                    System.err.println("ce.getChangedParent() : " + ce.getChangedParent());
                    passed = false;
                }
                ancestorResized[i] = true;
                resizeCount++;
                if (resizeCount == components.length) {
                    resizeTriggered = true;
                    synchronized (resizeLock) {
                        try {
                            resizeLock.notifyAll();
                        } catch (Exception e) {
                        }
                    }
                }
            }
        }
        return ce;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1855().ancestorResized(ce);
    }
}
