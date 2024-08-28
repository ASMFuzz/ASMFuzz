import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_7723 {

    static MBeanNotificationInfo[] notifs = new MBeanNotificationInfo[] { new MBeanNotificationInfo(new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE }, AttributeChangeNotification.class.getName(), "This notification is emitted when the reset() method is called.") };

    static String state = "initial state";

    static int nbChanges = 0;

    static int nbResets = 0;

    void reset() {
        state = "initial state";
        nbChanges = 0;
        nbResets++;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7723().reset();
    }
}
