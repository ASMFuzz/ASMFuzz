import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.print.*;

public class MyJVMTest_11695 {

    static int pageIndex = 9;

    static int MAXPAGE = 8;

    PageFormat getPageFormat(int pageIndex) {
        if (pageIndex > MAXPAGE)
            throw new IndexOutOfBoundsException();
        PageFormat pf = new PageFormat();
        Paper p = pf.getPaper();
        p.setImageableArea(36, 36, p.getWidth() - 72, p.getHeight() - 72);
        pf.setPaper(p);
        return pf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11695().getPageFormat(pageIndex));
    }
}
