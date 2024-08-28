import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;

public class MyJVMTest_5221 {

    static Object eventParam1 = 0;

    static String eventParam2 = "N_r)r!@Yqy";

    static Object eventParam3 = 2;

    static Object eventParam4 = 1;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    static boolean odd = false;

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) throws PropertyVetoException {
        this.odd = !this.odd;
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5221().vetoableChange(event);
    }
}
