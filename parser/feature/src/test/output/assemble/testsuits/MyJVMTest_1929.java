import java.util.concurrent.*;
import javax.management.*;

public class MyJVMTest_1929 {

    static String onParam1 = "P +/B&|nkY";

    static String onParam2 = "X#KGVdgZQ_";

    static String onParam3 = "GW((;y<#n=";

    static ObjectName on = new ObjectName(onParam1, onParam2, onParam3);

    static MBeanServer mbs = null;

    static ObjectName objectName = null;

    static Semaphore semaphore = null;

    ObjectName preRegister(MBeanServer mbs, ObjectName on) {
        this.objectName = on;
        return on;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_1929().preRegister(mbs, on));
    }
}
