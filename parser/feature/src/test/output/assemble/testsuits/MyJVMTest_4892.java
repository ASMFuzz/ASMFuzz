import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_4892 {

    static boolean flag = true;

    static boolean editChanged = false;

    boolean testEditChange(boolean flag) {
        if (editChanged != flag) {
            new RuntimeException("editChanged unexpectedly = " + editChanged);
        }
        editChanged = false;
        return flag;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4892().testEditChange(flag);
    }
}
