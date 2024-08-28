import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;

public class MyJVMTest_17774 {

    static Graphics g = new Graphics2D();

    static PageFormat pgFmt = new PageFormat();

    static int pgIndex = 8;

    int print(Graphics g, PageFormat pgFmt, int pgIndex) {
        int pageHeight = (int) pgFmt.getImageableHeight();
        int pageWidth = (int) pgFmt.getImageableWidth();
        System.out.println("imageable width = " + pageWidth + " height = " + pageHeight);
        return Printable.NO_SUCH_PAGE;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17774().print(g, pgFmt, pgIndex));
    }
}
