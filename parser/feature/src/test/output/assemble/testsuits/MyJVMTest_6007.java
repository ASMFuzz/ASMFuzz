import java.awt.*;
import sun.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.awt.dnd.*;
import java.awt.datatransfer.*;

public class MyJVMTest_6007 {

    static Window parent = null;

    static int width = 0, height = 0;

    Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6007().getPreferredSize());
    }
}
