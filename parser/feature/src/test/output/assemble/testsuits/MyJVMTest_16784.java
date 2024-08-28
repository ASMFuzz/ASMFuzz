import java.awt.*;
import java.awt.geom.*;

public class MyJVMTest_16784 {

    Dimension getPreferredSize() {
        return new Dimension(500, 600);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16784().getPreferredSize());
    }
}
