import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_15326 {

    static BufferedImage bimg = null;

    Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15326().getPreferredSize());
    }
}
