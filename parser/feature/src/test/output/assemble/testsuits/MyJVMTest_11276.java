import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_11276 {

    static int w = 2;

    static int h = 5;

    static BufferedImage image = null;

    int checkImage(int w, int h) {
        if (image == null || image.getWidth() < w || image.getHeight() < h) {
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }
        return h;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11276().checkImage(w, h);
    }
}
