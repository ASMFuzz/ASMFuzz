import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_7117 {

    static int button = 517523012;

    int getMask(int button) {
        return InputEvent.getMaskForButton(button);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7117().getMask(button));
    }
}
