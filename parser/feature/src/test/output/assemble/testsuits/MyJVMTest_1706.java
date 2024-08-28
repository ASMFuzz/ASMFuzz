import javax.management.*;
import javax.management.remote.*;
import javax.management.modelmbean.*;

public class MyJVMTest_1706 {

    static MBeanServerConnection mbsc = null;

    static String onParam1 = " g[}_2aokM";

    static ObjectName on = new ObjectName(onParam1);

    String test(MBeanServerConnection mbsc, ObjectName on) throws Exception {
        ModelMBeanInfo mmbi2 = (ModelMBeanInfo) mbsc.getMBeanInfo(on);
        Descriptor d2 = mmbi2.getDescriptor("getName", "operation");
        if (!"bar".equals(d2.getFieldValue("foo")))
            throw new Exception("TEST FAILED: bad descriptor: " + d2);
        String name = (String) mbsc.invoke(on, "getName", null, null);
        String thisName = Thread.currentThread().getName();
        if (!thisName.equals(name)) {
            throw new Exception("TEST FAILED: wrong thread name: " + name + " should be " + thisName);
        }
        return thisName;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1706().test(mbsc, on);
    }
}
