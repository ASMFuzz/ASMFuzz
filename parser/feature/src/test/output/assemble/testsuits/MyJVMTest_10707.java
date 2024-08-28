import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_10707 {

    static Frame frame = new Frame("Frame");

    static Window w = new Window(frame);

    static Dialog d = new Dialog((Dialog) null, "NullParentDialog", true);

    static Button button = new Button("Button");

    void run() {
        frame.setSize(200, 200);
        frame.setVisible(true);
        w.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        w.add(button);
        w.setSize(200, 200);
        w.setLocation(230, 230);
        w.setVisible(true);
        d.setSize(200, 200);
        d.setLocation(0, 230);
        d.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10707().run();
    }
}
