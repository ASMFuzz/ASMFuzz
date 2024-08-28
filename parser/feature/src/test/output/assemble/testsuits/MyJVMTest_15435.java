import java.awt.*;
import java.awt.image.*;

public class MyJVMTest_15435 {

    Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15435().getPreferredSize());
    }
}
