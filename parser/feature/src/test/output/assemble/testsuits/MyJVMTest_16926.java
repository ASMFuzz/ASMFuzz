import javax.management.*;
import javax.management.modelmbean.*;

public class MyJVMTest_16926 {

    static ModelMBean mmb = null;

    static ModelMBeanInfo mmbInfo = null;

    MBeanServer test(ModelMBean mmb) throws Exception {
        final MBeanServer mbs = MBeanServerFactory.createMBeanServer();
        final ObjectName name = new ObjectName("d:k=v");
        mbs.registerMBean(mmb, name);
        try {
            mbs.invoke(name, "noddy", null, null);
        } finally {
            mbs.unregisterMBean(name);
        }
        return mbs;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16926().test(mmb);
    }
}
