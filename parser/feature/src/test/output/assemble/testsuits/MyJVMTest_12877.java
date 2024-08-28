import java.awt.*;
import java.awt.event.*;
import java.awt.print.*;
import java.text.*;

public class MyJVMTest_12877 {

    Dimension getPreferredSize() {
        return new Dimension(450, 250);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12877().getPreferredSize());
    }
}
