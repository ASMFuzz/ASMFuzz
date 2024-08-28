import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class MyJVMTest_12634 {

    static Object eventParam1 = 2;

    static String eventParam2 = "}{?T%V]hIh";

    static Object eventParam3 = 3;

    static Object eventParam4 = 1002291491;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
        throw new PropertyVetoException("disable all changes", event);
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12634().vetoableChange(event);
    }
}
