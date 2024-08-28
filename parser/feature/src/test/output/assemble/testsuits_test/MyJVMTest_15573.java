import java.awt.*;
import javax.swing.*;

public class MyJVMTest_15573 {

    static int index = -33806474;

    Object getElementAt(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15573().getElementAt(index));
    }
}
