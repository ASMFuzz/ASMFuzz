import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.*;

public class MyJVMTest_1553 {

    static String msg = "eOw<f!*Eva";

    static Shape s = null;

    Shape testShape(String msg, Shape s) {
        if (!(new Area(s).isEmpty())) {
            System.out.println(msg + "=" + s);
            throw new RuntimeException("Warning: expected this to be empty");
        }
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1553().testShape(msg, s);
    }
}
