import javax.swing.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;

public class MyJVMTest_3633 {

    Dimension getPreferredSize() {
        return new Dimension(400, 300);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3633().getPreferredSize());
    }
}
