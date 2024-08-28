import java.awt.*;
import java.awt.image.*;
import java.util.*;
import javax.swing.*;

public class MyJVMTest_13630 {

    BufferedImage createSrcImage() {
        BufferedImage bi = new BufferedImage(10, 10, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = (Graphics2D) bi.getGraphics();
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 10, 10);
        return bi;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13630().createSrcImage());
    }
}
