import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_11082 {

    static Component ceParam1 = new Container();

    static int ceParam2 = 960;

    static Component ceParam3 = new Container();

    static Container ceParam4 = new Container();

    static long ceParam5 = -9223372036854775808L;

    static HierarchyEvent ce = new HierarchyEvent(ceParam1, ceParam2, ceParam3, ceParam4, ceParam5);

    static Frame frame = null, dummy = null;

    static Component[] components = {null,null,null,null,null,null,null,null,null,null};

    static boolean[] ancestorResized = {true,true,true,false,true,true,false,true,true,true};

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
        new MyJVMTest_11082().ancestorResized(ce);
    }
}
