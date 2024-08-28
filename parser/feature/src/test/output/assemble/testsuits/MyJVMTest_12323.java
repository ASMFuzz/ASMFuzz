import javax.management.*;
import java.util.concurrent.*;

public class MyJVMTest_12323 {

    static String nameParam1 = "JLLGy\\BP `";

    static ObjectName name = new ObjectName(nameParam1);

    long next() {
        return next++;
    }

    static String type = "W9t{dfkmy@";

    static long next = 0;

    MBeanServerNotification create(ObjectName name) {
        return new MBeanServerNotification(type, MBeanServerDelegate.DELEGATE_NAME, next(), name);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12323().create(name));
    }
}
