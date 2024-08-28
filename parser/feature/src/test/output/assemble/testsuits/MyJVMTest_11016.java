import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_11016 {

    static int SIZE = 300;

    Dimension getPreferredSize() {
        return new Dimension(SIZE, SIZE);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11016().getPreferredSize());
    }
}
