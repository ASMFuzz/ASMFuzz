import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_5903 {

    static BufferedImage image = null;

    Dimension getPreferredSize() {
        if (image == null) {
            return new Dimension();
        } else {
            return new Dimension(image.getWidth(), image.getHeight());
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5903().getPreferredSize());
    }
}
