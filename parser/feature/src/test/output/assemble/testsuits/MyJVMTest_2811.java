import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.io.*;

public class MyJVMTest_2811 {

    static Graphics g = new Graphics2D();

    static BufferedImage image = null;

    Graphics paint(Graphics g) {
        g.drawImage(image, 0, 0, null);
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2811().paint(g);
    }
}
