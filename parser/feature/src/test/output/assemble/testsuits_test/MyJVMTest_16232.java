import java.beans.PropertyChangeEvent;

public class MyJVMTest_16232 {

    static Object eventParam1 = 8;

    static String eventParam2 = "n6b_^;+tcP";

    static Object eventParam3 = 4;

    static Object eventParam4 = -1731422197;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    PropertyChangeEvent propertyChange(PropertyChangeEvent event) {
        System.out.println("* propertyChange(event) event is " + event.getPropertyName());
        throw new Error("shouldn't be any listeners");
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16232().propertyChange(event);
    }
}
