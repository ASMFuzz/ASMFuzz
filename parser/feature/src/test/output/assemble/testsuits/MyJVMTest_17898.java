import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_17898 {

    Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17898().getPreferredSize());
    }
}
