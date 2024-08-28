import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class MyJVMTest_3309 {

    static Object eventParam1 = 3;

    static String eventParam2 = ".I-|[zpcrp";

    static Object eventParam3 = 8;

    static Object eventParam4 = 1469334208;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
        throw new PropertyVetoException("disable all changes", event);
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3309().vetoableChange(event);
    }
}
