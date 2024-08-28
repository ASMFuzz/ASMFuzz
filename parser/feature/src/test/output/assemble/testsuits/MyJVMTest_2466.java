import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_2466 {

    static int TESTW = 600;

    static int TESTH = 500;

    static RescaleOp rescale1band = null, rescale3band = null, rescale4band = null;

    Dimension getPreferredSize() {
        return new Dimension(TESTW, TESTH);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2466().getPreferredSize());
    }
}
