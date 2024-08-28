import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_2744 {

    static String s = "d.oTS\"4fi^";

    static MBeanNotificationInfo[] notifs = new MBeanNotificationInfo[] { new MBeanNotificationInfo(new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE }, AttributeChangeNotification.class.getName(), "This notification is emitted when the reset() method is called.") };

    static String state = "initial state";

    static int nbChanges = 0;

    String setState(String s) {
        state = s;
        nbChanges++;
        return s;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2744().setState(s);
    }
}
