import java.beans.PropertyChangeEvent;

public class MyJVMTest_10656 {

    static Object eventParam1 = 0;

    static String eventParam2 = "^zZJs#!c{[";

    static Object eventParam3 = 751455247;

    static Object eventParam4 = 202958376;

    static PropertyChangeEvent event = new PropertyChangeEvent(eventParam1, eventParam2, eventParam3, eventParam4);

    static int current = -387002511;

    static int index = 7;

    PropertyChangeEvent vetoableChange(PropertyChangeEvent event) {
        if (this.index < 0)
            throw new Error("Unexpected listener: " + this.index);
        System.out.println("index = " + this.index);
        if (this.index != current++)
            throw new Error("Unexpected listener: " + this.index);
        return event;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10656().vetoableChange(event);
    }
}
