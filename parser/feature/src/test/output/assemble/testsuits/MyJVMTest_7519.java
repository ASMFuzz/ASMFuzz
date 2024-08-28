import java.io.*;
import java.lang.management.*;
import javax.management.*;
import javax.management.openmbean.*;

public class MyJVMTest_7519 {

    static MBeanServer mbs = null;

    static String onParam1 = "!&@MVIA)%H";

    static ObjectName on = new ObjectName(onParam1);

    static String immutable = "U{lst0JLsp";

    static String intf = "INo2U3%eU\"";

    String getName() {
        return "name";
    }

    static MBeanNotificationInfo[] notifs = new MBeanNotificationInfo[] { new MBeanNotificationInfo(new String[] { AttributeChangeNotification.ATTRIBUTE_CHANGE }, AttributeChangeNotification.class.getName(), "This notification is emitted when the reset() method is called.") };

    static int nbChanges = 0;

    Descriptor checkDescriptor(MBeanServer mbs, ObjectName on, String immutable, String intf) throws Exception {
        MBeanInfo mbi = mbs.getMBeanInfo(on);
        Descriptor d = mbi.getDescriptor();
        if (d == null || d.getFieldNames().length == 0)
            throw new IllegalArgumentException("Empty descriptor");
        if (!d.getFieldValue("immutableInfo").equals(immutable)) {
            final String msg = "Bad descriptor: expected immutableInfo=" + immutable + ": " + d;
            throw new IllegalArgumentException(msg);
        }
        if (!d.getFieldValue("interfaceClassName").equals(intf)) {
            final String msg = "Bad descriptor: expected interfaceClassName=" + intf + ": " + d;
            throw new IllegalArgumentException(msg);
        }
        if (intf.indexOf("MX") != -1) {
            MBeanAttributeInfo[] attrs = mbi.getAttributes();
            if (attrs == null || attrs.length == 0)
                throw new IllegalArgumentException("No attributes");
            boolean nbChangesFound = false;
            for (MBeanAttributeInfo attr : attrs) {
                if (attr.getName().equals("NbChanges")) {
                    nbChangesFound = true;
                    Descriptor ad = attr.getDescriptor();
                    OpenType<?> opty = (OpenType<?>) ad.getFieldValue("openType");
                    if (!opty.equals(SimpleType.INTEGER)) {
                        throw new IllegalArgumentException("Open type should " + "be INTEGER: " + opty);
                    }
                    String orty = (String) ad.getFieldValue("originalType");
                    if (!orty.equals(Integer.TYPE.getName())) {
                        throw new IllegalArgumentException("Orig type should " + "be int: " + orty);
                    }
                }
            }
            if (!nbChangesFound)
                throw new IllegalArgumentException("Did not find NbChanges");
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7519().checkDescriptor(mbs, on, immutable, intf);
    }
}
