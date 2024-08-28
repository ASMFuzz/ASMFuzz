import javax.swing.*;
import java.beans.*;
import java.util.concurrent.atomic.*;
import java.util.concurrent.*;

public class MyJVMTest_15835 {

    static Object evtParam1 = 796771548;

    static String evtParam2 = "4%<DDxf>/@";

    static Object evtParam3 = 0;

    static Object evtParam4 = 8;

    static PropertyChangeEvent evt = new PropertyChangeEvent(evtParam1, evtParam2, evtParam3, evtParam4);

    static AtomicInteger lastProgressValue = new AtomicInteger(-1);

    PropertyChangeEvent propertyChange(PropertyChangeEvent evt) {
        if ("progress" == evt.getPropertyName()) {
            lastProgressValue.set((Integer) evt.getNewValue());
        }
        return evt;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15835().propertyChange(evt);
    }
}
