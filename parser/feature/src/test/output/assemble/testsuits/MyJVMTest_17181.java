import java.beans.PropertyChangeEvent;

public class MyJVMTest_17181 {

    static Object eventParam1 = 4;

    static String eventParam2 = "rr9&'`gR^u";

    static Object eventParam3 = 4;

    static Object eventParam4 = 1;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) {
        System.out.println("* vetoableChange(event) event is " + event.getPropertyName());
        throw new Error("shouldn't be any listeners");
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17181().vetoableChange(event);
    }
}
