import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.print.*;

public class MyJVMTest_16766 {

    Dimension getPreferredSize() {
        return new Dimension(100, 100);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16766().getPreferredSize());
    }
}
