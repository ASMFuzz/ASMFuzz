import java.awt.*;
import sun.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class MyJVMTest_7588 {

    static int step = 3;

    static Window parent = null;

    static int width = 7, height = 0;

    int changeSize(int step) {
        width += step;
        height += step;
        parent.pack();
        return step;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7588().changeSize(step);
    }
}
