import javax.swing.*;
import java.beans.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class MyJVMTest_6355 {

    static Object evtParam1 = 0;

    static String evtParam2 = "(~[&O[Rylq";

    static Object evtParam3 = 5;

    static Object evtParam4 = 0;

    static PropertyChangeEvent evt = new PropertyChangeEvent(evtParam1, evtParam2, evtParam3, evtParam4);

    static AtomicInteger lastProgressValue = new AtomicInteger(-1);

    PropertyChangeEvent propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            lastProgressValue.set((Integer) evt.getNewValue());
        }
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6355().propertyChange(evt);
    }
}
