import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class MyJVMTest_14638 {

    static Object eventParam1 = 0;

    static String eventParam2 = "B?*Md7?B!V";

    static Object eventParam3 = 0;

    static Object eventParam4 = 0;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    static boolean odd = false;

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
        this.odd = !this.odd;
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14638().vetoableChange(event);
    }
}
