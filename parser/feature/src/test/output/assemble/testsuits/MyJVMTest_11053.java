import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.*;
import java.applet.Applet;

public class MyJVMTest_11053 {

    static Frame frame = new Frame("Modal Blocked Frame");

    static Dialog dialog = new Dialog(frame, "Modal Dialog", true);

    static Window excluded = new Window(frame);

    static Button button = new Button("button");

    void run() {
        frame.setSize(300, 200);
        frame.setVisible(true);
        excluded.setSize(300, 200);
        excluded.setLocation(0, 400);
        excluded.setModalExclusionType(Dialog.ModalExclusionType.TOOLKIT_EXCLUDE);
        excluded.setLayout(new FlowLayout());
        excluded.add(button);
        excluded.setVisible(true);
        dialog.setSize(200, 100);
        dialog.setLocation(0, 250);
        dialog.setVisible(true);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11053().run();
    }
}
