import java.beans.PropertyChangeEvent;

public class MyJVMTest_1442 {

    static Object eventParam1 = 5;

    static String eventParam2 = "~63\\>i[U0k";

    static Object eventParam3 = 0;

    static Object eventParam4 = 0;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    static int current = 2016761342;

    static int index = 0;

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) {
        if (this.index < 0)
            throw new Error("Unexpected listener: " + this.index);
        System.out.println("index = " + this.index);
        if (this.index != current++)
            throw new Error("Unexpected listener: " + this.index);
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1442().vetoableChange(event);
    }
}
