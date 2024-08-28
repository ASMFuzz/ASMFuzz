import java.awt.*;
import java.awt.print.*;

public class MyJVMTest_8069 {

    static int pageIndex = 6;

    PageFormat getPageFormat(int pageIndex) throws IndexOutOfBoundsException {
        PageFormat pf = null;
        if (pageIndex >= 10) {
            throw new IndexOutOfBoundsException("Wrong page#");
        }
        switch(pageIndex) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 8:
                pf = new PageFormat();
                pf.setOrientation(PageFormat.REVERSE_LANDSCAPE);
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                pf = new PageFormat();
                pf.setOrientation(PageFormat.LANDSCAPE);
                break;
        }
        return pf;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8069().getPageFormat(pageIndex));
    }
}
