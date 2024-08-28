import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_4908 {

    static MBeanNotificationInfo[] notifs = new MBeanNotificationInfo[] { new MBeanNotificationInfo(new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE }, AttributeChangeNotification.class.getName(), "This notification is emitted when the reset() method is called.") };

    MemoryUsage getMemoryUsage() {
        return new MemoryUsage(10, 20, 30, 40);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_4908().getMemoryUsage());
    }
}
