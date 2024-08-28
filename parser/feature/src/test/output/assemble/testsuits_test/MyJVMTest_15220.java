import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_15220 {

    Dimension getPreferredSize() {
        return new Dimension(500, 300);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15220().getPreferredSize());
    }
}
