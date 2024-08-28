import java.awt.*;
import java.awt.print.*;
import javax.print.*;

public class MyJVMTest_12287 {

    static int orient = 0;

    String findOrientation(int orient) {
        if (orient == PageFormat.LANDSCAPE) {
            return "LANDSCAPE";
        } else if (orient == PageFormat.PORTRAIT) {
            return "PORTRAIT";
        } else if (orient == PageFormat.REVERSE_LANDSCAPE) {
            return "REVERSE LANDSCAPE";
        } else {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12287().findOrientation(orient));
    }
}
