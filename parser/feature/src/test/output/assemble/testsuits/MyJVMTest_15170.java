import java.awt.*;
import java.awt.print.*;

public class MyJVMTest_15170 {

    static Graphics g = new Graphics2D();

    static PageFormat pgFmt = new PageFormat();

    static int pgIndex = 3;

    int print(Graphics g, PageFormat pgFmt, int pgIndex) {
        if (pgIndex > 0)
            return Printable.NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pgFmt.getImageableX(), pgFmt.getImageableY());
        Image imgJava = Toolkit.getDefaultToolkit().getImage("img.bad");
        g2d.drawImage(imgJava, 0, 0, null);
        return Printable.PAGE_EXISTS;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15170().print(g, pgFmt, pgIndex));
    }
}
