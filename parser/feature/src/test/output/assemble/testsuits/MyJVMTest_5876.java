import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_5876 {

    static BufferedImage bimg = null;

    Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5876().getPreferredSize());
    }
}
