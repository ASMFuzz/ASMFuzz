import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_13633 {

    static int TESTW = 600;

    static int TESTH = 500;

    Dimension getPreferredSize() {
        return new Dimension(TESTW, TESTH);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13633().getPreferredSize());
    }
}
