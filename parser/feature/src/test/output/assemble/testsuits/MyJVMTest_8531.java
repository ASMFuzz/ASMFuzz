import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;

public class MyJVMTest_8531 {

    static FileDialog fd = null;

    void run() {
        fd.setDirectory(System.getProperty("test.src", "."));
        fd.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_8531().run();
    }
}
