import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.*;

public class MyJVMTest_7217 {

    static Graphics g = new Graphics2D();

    static PageFormat pf = new PageFormat();

    static int pageIndex = 1;

    static TextField tf = new TextField();

    static Label tfLabel = new Label("File Name");

    static Panel p = new Panel(new GridLayout(2, 2));

    static Button b = new Button("Print");

    int print(Graphics g, PageFormat pf, int pageIndex) {
        Graphics2D g2 = (Graphics2D) g;
        if (pageIndex >= 1) {
            return Printable.NO_SUCH_PAGE;
        }
        g2.drawString("hello world", 100, 100);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7217().print(g, pf, pageIndex));
    }
}
