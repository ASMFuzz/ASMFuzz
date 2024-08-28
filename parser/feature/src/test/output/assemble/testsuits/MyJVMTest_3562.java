import javax.swing.*;
import java.awt.*;

public class MyJVMTest_3562 {

    Dimension getPreferredSize() {
        return new Dimension(1200, 400);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3562().getPreferredSize());
    }
}
