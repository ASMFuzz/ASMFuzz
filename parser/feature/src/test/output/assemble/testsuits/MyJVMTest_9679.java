import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_9679 {

    Dimension getPreferredSize() {
        return new Dimension(400, 800);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9679().getPreferredSize());
    }
}
