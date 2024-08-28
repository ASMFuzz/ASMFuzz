import java.awt.*;
import java.awt.event.*;

public class MyJVMTest_15889 {

    static Object evtParam1 = -1376258057;

    static int evtParam2 = 118;

    static String evtParam3 = "^0T|pw!%q)";

    static ActionEvent evt = new ActionEvent(evtParam1, evtParam2, evtParam3);

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
        new MyJVMTest_15889().actionPerformed(evt);
    }
}
