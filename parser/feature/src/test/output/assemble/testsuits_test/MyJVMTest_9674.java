import javax.print.*;
import java.applet.*;
import java.awt.*;

public class MyJVMTest_9674 {

    static Graphics g = new Graphics2D();

    static String name = "Applet 0 ";

    static PrintService defServ = null;

    static PrintService[] allServices = null;

    static StreamPrintServiceFactory[] fact = null;

    Graphics paint(Graphics g) {
        g.drawString("This is " + name, 10, 20);
        g.drawString("Default print service=" + defServ, 10, 40);
        g.drawString("Number of print services=" + allServices.length, 10, 60);
        g.drawString("Number of PS stream services=" + fact.length, 10, 80);
        int y = 100;
        for (int i = 0; i < allServices.length; i++) {
            if (allServices[i].getName().startsWith("Applet ")) {
                g.drawString("Found service : " + allServices[i].getName(), 10, y);
                y += 20;
            }
        }
        return g;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9674().paint(g);
    }
}
