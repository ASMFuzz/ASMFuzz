import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class MyJVMTest_1885 {

    static Object eventParam1 = 6;

    static String eventParam2 = "0;u5oxUf78";

    static Object eventParam3 = 0;

    static Object eventParam4 = 3;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    static boolean veto = true;

    static boolean odd = false;

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
        this.odd = !this.odd;
        if (this.veto)
            throw new PropertyVetoException("disable all changes", event);
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1885().vetoableChange(event);
    }
}
