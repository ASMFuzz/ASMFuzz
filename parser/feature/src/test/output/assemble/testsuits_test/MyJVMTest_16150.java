import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_16150 {

    Dimension getPreferredSize() {
        return new Dimension(659, 792);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16150().getPreferredSize());
    }
}
