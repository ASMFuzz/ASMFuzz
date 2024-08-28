import java.awt.*;
import javax.swing.*;

public class MyJVMTest_8481 {

    static int index = 2;

    String getElementAt(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_8481().getElementAt(index));
    }
}
