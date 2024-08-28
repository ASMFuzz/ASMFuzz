import java.awt.*;
import javax.swing.*;

public class MyJVMTest_18070 {

    static int index = 0;

    String getElementAt(int index) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18070().getElementAt(index));
    }
}
