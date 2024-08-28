import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;

public class MyJVMTest_15954 {

    Dimension getPreferredSize() {
        return new Dimension(250, 100);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15954().getPreferredSize());
    }
}
