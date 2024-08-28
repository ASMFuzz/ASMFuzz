import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.*;

public class MyJVMTest_15860 {

    static boolean focusGained = false;

    static Object monitor = new Object();

    boolean isFocusGained() {
        synchronized (monitor) {
            if (!focusGained) {
                try {
                    monitor.wait(3000);
                } catch (InterruptedException e) {
                    Sysout.println("Interrupted unexpectedly!");
                    throw new RuntimeException(e);
                }
            }
        }
        return focusGained;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15860().isFocusGained());
    }
}
