import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_7923 {

    static ScrollPane pane = null;

    static MyCanvas myCanvas = null;

    Dimension getPreferredSize() {
        return new Dimension(400, 800);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7923().getPreferredSize());
    }
}
