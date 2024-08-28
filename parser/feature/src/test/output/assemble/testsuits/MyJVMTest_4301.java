import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import java.io.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_4301 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 7;

    int print(Graphics g, PageFormat pf, int pageIndex) {
        if (pageIndex > 0) {
            return Printable.NO_SUCH_PAGE;
        }
        Graphics2D g2 = (Graphics2D) g;
        GraphicsConfiguration gConfig = g2.getDeviceConfiguration();
        AffineTransform dt = gConfig.getDefaultTransform();
        AffineTransform nt = gConfig.getNormalizingTransform();
        AffineTransform gt = g2.getTransform();
        System.out.println("Graphics2D transform = " + gt);
        System.out.println("Default transform = " + dt);
        System.out.println("Normalizing transform = " + nt);
        Rectangle bounds = gConfig.getBounds();
        System.out.println("Bounds = " + bounds);
        if (!nt.isIdentity()) {
            throw new RuntimeException("Expected Identity transdform");
        }
        GraphicsDevice gd = gConfig.getDevice();
        System.out.println("Printer Device ID = " + gd.getIDstring());
        if (!(gd.getType() == GraphicsDevice.TYPE_PRINTER)) {
            throw new RuntimeException("Expected printer device");
        }
        System.out.println(" *** ");
        System.out.println("");
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4301().print(g, pf, pageIndex));
    }
}
