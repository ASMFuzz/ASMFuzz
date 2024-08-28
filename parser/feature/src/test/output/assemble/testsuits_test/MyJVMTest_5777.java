import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_5777 {

    Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5777().getPreferredSize());
    }
}
