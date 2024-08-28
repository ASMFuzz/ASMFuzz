import java.util.*;
import java.text.*;
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.renderable.*;
import javax.swing.*;
import javax.swing.text.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class MyJVMTest_15989 {

    static BufferedImage _image = null;

    static PageFormat _pageFormat = null;

    BufferedImage prepareFrontImage() {
        BufferedImage result = new BufferedImage(400, 200, BufferedImage.TYPE_BYTE_GRAY);
        Graphics2D g2D = (Graphics2D) result.getGraphics();
        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
        int w = result.getWidth(), h = result.getHeight();
        g2D.setColor(Color.gray);
        g2D.fill(new Rectangle(0, 0, w, h));
        g2D.setColor(Color.white);
        AffineTransform original = g2D.getTransform();
        AffineTransform originXform = AffineTransform.getTranslateInstance(w / 5, h / 5);
        g2D.transform(originXform);
        g2D.drawString("Front Side", 20, h / 2);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15989().prepareFrontImage());
    }
}
