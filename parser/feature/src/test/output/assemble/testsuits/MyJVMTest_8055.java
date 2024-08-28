import java.awt.*;
import java.awt.event.*;
import java.awt.font.*;
import static java.awt.font.TextAttribute.*;

public class MyJVMTest_8055 {

    static DrawStrSuper dss = null;

    Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8055().getPreferredSize());
    }
}
