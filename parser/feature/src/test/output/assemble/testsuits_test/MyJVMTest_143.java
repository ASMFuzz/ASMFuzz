import java.net.MalformedURLException;
import javax.management.MBeanNotificationInfo;
import java.util.Arrays;

public class MyJVMTest_143 {

    static String myType = "notification.my_notification";

    MBeanNotificationInfo[] getNotificationInfo() {
        final String[] ntfTypes = { myType };
        final MBeanNotificationInfo[] ntfInfoArray = { new MBeanNotificationInfo(ntfTypes, "javax.management.Notification", "Notifications sent by the NotificationEmitter") };
        return ntfInfoArray;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_143().getNotificationInfo()));
    }
}
