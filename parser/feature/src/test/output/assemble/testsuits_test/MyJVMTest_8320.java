import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_8320 {

    Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8320().getPreferredSize());
    }
}
