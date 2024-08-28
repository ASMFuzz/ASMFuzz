import javax.management.*;
import javax.management.remote.*;
import java.lang.management.ManagementFactory;

public class MyJVMTest_12030 {

    static String infoParam1 = "F}Ltn]<d\\K";

    static Method infoParam2 = null;

    static MBeanOperationInfo info = new MBeanOperationInfo(infoParam1, infoParam2);

    Descriptor printOperation(MBeanOperationInfo info) {
        System.out.println("Name: " + info.getName());
        System.out.println("Description: " + info.getDescription());
        System.out.println("Return Type: " + info.getReturnType());
        System.out.println("Impact: " + info.getImpact());
        Descriptor desc = info.getDescriptor();
        System.out.println("Descriptor");
        for (int i = 0; i < desc.getFieldNames().length; i++) {
            if (desc.getFieldNames()[i].compareTo("dcmd.arguments") == 0) {
                System.out.println("\t" + desc.getFieldNames()[i] + ":");
                Descriptor desc2 = (Descriptor) desc.getFieldValue(desc.getFieldNames()[i]);
                for (int j = 0; j < desc2.getFieldNames().length; j++) {
                    System.out.println("\t\t" + desc2.getFieldNames()[j] + "=");
                    Descriptor desc3 = (Descriptor) desc2.getFieldValue(desc2.getFieldNames()[j]);
                    for (int k = 0; k < desc3.getFieldNames().length; k++) {
                        System.out.println("\t\t\t" + desc3.getFieldNames()[k] + "=" + desc3.getFieldValue(desc3.getFieldNames()[k]));
                    }
                }
            } else {
                System.out.println("\t" + desc.getFieldNames()[i] + "=" + desc.getFieldValue(desc.getFieldNames()[i]));
            }
        }
        return desc;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_12030().printOperation(info);
    }
}
