import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class MyJVMTest_5473 {

    static int SZ = 150;

    Dimension getPreferredSize() {
        return new Dimension(SZ, SZ);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5473().getPreferredSize());
    }
}
