import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyJVMTest_2864 {

    static TestDialog dialog = null;

    boolean failStatus() {
        return dialog.failStatus;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2864().failStatus());
    }
}
