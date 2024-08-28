import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_2031 {

    static int w = 1;

    static int h = -2013530497;

    static BufferedImage image = null;

    int checkImage(int w, int h) {
        if (image == null || image.getWidth() < w || image.getHeight() < h) {
            image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        }
        return h;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2031().checkImage(w, h);
    }
}
