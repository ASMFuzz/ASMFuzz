import java.beans.PropertyChangeEvent;

public class MyJVMTest_7633 {

    static Object eventParam1 = 4;

    static String eventParam2 = "5?>magw&)[";

    static Object eventParam3 = 7;

    static Object eventParam4 = 5;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) {
        System.out.println("* vetoableChange(event) event is " + event.getPropertyName());
        throw new Error("shouldn't be any listeners");
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7633().vetoableChange(event);
    }
}
