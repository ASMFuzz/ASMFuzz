import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MyJVMTest_9696 {

    static String wParam1Param1Param1Param1 = "'&]AnNa2D#";

    static Frame wParam1Param1Param1 = new Frame(wParam1Param1Param1Param1);

    static Window wParam1Param1 = new Window(wParam1Param1Param1);

    static Window wParam1 = new Window(wParam1Param1);

    static GraphicsConfiguration wParam2 = null;

    static Window w = new Window(wParam1, wParam2);

    static Vector<Window> frames = new Vector<Window>();

    static Vector<Window> windows = new Vector<Window>();

    static Vector<Window> ownerless = new Vector<Window>();

    Window addToWindowsList(Window w) {
        if (w instanceof Frame) {
            frames.add(w);
        }
        windows.add(w);
        if (w.getOwner() == null) {
            ownerless.add(w);
        }
        return w;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9696().addToWindowsList(w);
    }
}
