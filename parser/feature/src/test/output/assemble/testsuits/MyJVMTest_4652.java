import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_4652 {

    Dimension getPreferredSize() {
        return new Dimension(500, 500);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4652().getPreferredSize());
    }
}
