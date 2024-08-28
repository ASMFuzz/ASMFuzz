import java.beans.PropertyChangeEvent;

public class MyJVMTest_6735 {

    static Object eventParam1 = -965291639;

    static String eventParam2 = "W,RHgp7C[(";

    static Object eventParam3 = 9993088;

    static Object eventParam4 = -692422301;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    PropertyChangeEvent propertyChange(PropertyChangeEvent event) {
        System.out.println("* propertyChange(event) event is " + event.getPropertyName());
        throw new Error("shouldn't be any listeners");
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6735().propertyChange(event);
    }
}
