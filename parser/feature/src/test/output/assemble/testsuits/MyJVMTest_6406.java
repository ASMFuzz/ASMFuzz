import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_6406 {

    static Object evtParam1 = 0;

    static int evtParam2 = 894;

    static String evtParam3 = "K/MpF-[:pv";

    static int evtParam4 = 817;

    static ActionEvent evt = new ActionEvent(evtParam1, evtParam2, evtParam3, evtParam4);

    static Button b1 = new Button("Disable");

    static Button b3 = new Button("Dummy");

    static TextField b2 = new TextField("Click Me");

    static Panel p = new Panel(new GridLayout(1, 3));

    static MenuItem exit = new MenuItem("exit");

    static boolean success = false;

    ActionEvent actionPerformed(ActionEvent evt) {
        if (evt.getSource() == b1) {
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
        } else if (evt.getSource() == exit) {
            success = true;
        }
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6406().actionPerformed(evt);
    }
}
