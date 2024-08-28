import java.awt.*;
import java.awt.dnd.*;
import java.applet.Applet;

public class MyJVMTest_12074 {

    Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12074().getPreferredSize());
    }
}
