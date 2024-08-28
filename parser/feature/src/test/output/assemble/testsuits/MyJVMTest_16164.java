import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_16164 {

    static BufferedImage bimg = null;

    Dimension getPreferredSize() {
        return new Dimension(bimg.getWidth(), bimg.getHeight());
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16164().getPreferredSize());
    }
}
