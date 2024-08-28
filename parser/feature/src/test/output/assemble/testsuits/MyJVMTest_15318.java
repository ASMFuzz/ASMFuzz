import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.modelmbean.*;

public class MyJVMTest_15318 {

    static ModelMBeanInfo modelMBeanInfo = null;

    static Descriptor[] descriptors = { null, null, null, null, null, null, null, null, null, null };

    static String string = "@60LPnzaQk";

    Descriptor remove(ArrayList<Descriptor> list, Descriptor item) {
        if (list.remove(item))
            return item;
        else
            return null;
    }

    ArrayList<Descriptor> checkDescriptors(ModelMBeanInfo modelMBeanInfo, Descriptor[] descriptors, String string) {
        int errCount = 0;
        final ArrayList<Descriptor> list = new ArrayList<Descriptor>(descriptors.length);
        list.addAll(Arrays.asList(descriptors));
        System.out.println("Got " + list.size() + " descriptors for " + string);
        final Descriptor mbd = ((MBeanInfo) modelMBeanInfo).getDescriptor();
        if (!mbd.equals(remove(list, mbd))) {
            System.err.println("modelMBeanInfo.getDescriptor(): not found");
            errCount++;
        }
        final MBeanAttributeInfo[] attrs = modelMBeanInfo.getAttributes();
        for (MBeanAttributeInfo att : attrs) {
            final Descriptor ad = att.getDescriptor();
            final String name = att.getName();
            if (!ad.equals(remove(list, ad))) {
                System.err.println("attInfo.getDescriptor(): not found for " + name);
                errCount++;
            }
        }
        final MBeanOperationInfo[] ops = modelMBeanInfo.getOperations();
        for (MBeanOperationInfo op : ops) {
            final Descriptor od = op.getDescriptor();
            final String name = op.getName();
            if (!od.equals(remove(list, od))) {
                System.err.println("opInfo.getDescriptor(): not found for " + name);
                errCount++;
            }
        }
        final MBeanNotificationInfo[] ntfs = modelMBeanInfo.getNotifications();
        for (MBeanNotificationInfo ntf : ntfs) {
            final Descriptor nd = ntf.getDescriptor();
            final String name = ntf.getName();
            if (!nd.equals(remove(list, nd))) {
                System.err.println("notifInfo.getDescriptor(): not found for " + name);
                errCount++;
            }
        }
        if (errCount > 0) {
            throw new RuntimeException(string + ": failed with " + errCount + " errors");
        } else if (list.size() != 0) {
            throw new RuntimeException(string + ": Unexpected remaining descriptors: " + list);
        } else
            System.out.println(string + ": PASSED");
        return list;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15318().checkDescriptors(modelMBeanInfo, descriptors, string);
    }
}
