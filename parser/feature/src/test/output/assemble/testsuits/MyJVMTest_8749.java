import java.awt.*;
import sun.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class MyJVMTest_8749 {

    static int step = -2043606848;

    static Window parent = null;

    static int width = 9, height = 6;

    int changeSize(int step) {
        width += step;
        height += step;
        parent.pack();
        return step;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8749().changeSize(step);
    }
}
