import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class MyJVMTest_16636 {

    static int button = 0;

    int getMask(int button) {
        return InputEvent.getMaskForButton(button);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16636().getMask(button));
    }
}
