import javax.management.*;
import java.util.Arrays;

public class MyJVMTest_13639 {

    static int called = 706508432;

    MBeanNotificationInfo[] getNotificationInfo() {
        MBeanNotificationInfo inf = new MBeanNotificationInfo(new String[0], Integer.toString(++called), "description");
        return new MBeanNotificationInfo[] { inf };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_13639().getNotificationInfo()));
    }
}
