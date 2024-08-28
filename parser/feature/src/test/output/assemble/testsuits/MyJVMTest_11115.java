import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class MyJVMTest_11115 {

    static Object eventParam1 = 2;

    static String eventParam2 = "FWl5%y65F2";

    static Object eventParam3 = 0;

    static Object eventParam4 = -89588334;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    static boolean veto = true;

    static boolean odd = true;

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
        this.odd = !this.odd;
        if (this.veto)
            throw new PropertyVetoException("disable all changes", event);
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11115().vetoableChange(event);
    }
}
