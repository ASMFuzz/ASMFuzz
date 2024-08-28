import javax.management.*;
import java.util.concurrent.*;

public class MyJVMTest_3017 {

    static String nameParam1 = "Qy5,tXq^9^";

    static String nameParam2 = "69OVa`YL8T";

    static String nameParam3 = "db[pbb\\8#Q";

    static ObjectName name = new ObjectName(nameParam1, nameParam2, nameParam3);

    long next() {
        return next++;
    }

    static String type = "xQ`=3Uuw`&";

    static long next = 0;

    MBeanServerNotification create(ObjectName name) {
        return new MBeanServerNotification(type, MBeanServerDelegate.DELEGATE_NAME, next(), name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3017().create(name));
    }
}
