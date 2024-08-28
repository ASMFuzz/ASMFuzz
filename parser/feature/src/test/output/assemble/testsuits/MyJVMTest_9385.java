import java.awt.print.*;
import javax.print.*;

public class MyJVMTest_9385 {

    static PageFormat pf = new PageFormat();

    PageFormat displayPageFormat(PageFormat pf) {
        System.out.println("------- Page Format -------");
        System.out.println("ImageableX = " + pf.getImageableX());
        System.out.println("ImageableY = " + pf.getImageableY());
        System.out.println("ImageableWidth = " + pf.getImageableWidth());
        System.out.println("ImageableHeight = " + pf.getImageableHeight());
        System.out.println("Width = " + pf.getWidth());
        System.out.println("Height = " + pf.getHeight());
        return pf;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9385().displayPageFormat(pf);
    }
}
