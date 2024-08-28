import java.util.*;
import javax.management.modelmbean.*;

public class MyJVMTest_17279 {

    static String mmbiParam1 = "1j5[!MOiyS";

    static String mmbiParam2 = "gU-n)v$,ug";

    static ModelMBeanAttributeInfo[] mmbiParam3 = { null, null, null, null, null, null, null, null, null, null };

    static ModelMBeanConstructorInfo[] mmbiParam4 = { null, null, null, null, null, null, null, null, null, null };

    static ModelMBeanOperationInfo[] mmbiParam5 = { null, null, null, null, null, null, null, null, null, null };

    static ModelMBeanNotificationInfo[] mmbiParam6 = { null, null, null, null, null, null, null, null, null, null };

    static Descriptor mmbiParam7 = null;

    static ModelMBeanInfoSupport mmbi = new ModelMBeanInfoSupport(mmbiParam1, mmbiParam2, mmbiParam3, mmbiParam4, mmbiParam5, mmbiParam6, mmbiParam7);

    static String what = "ea>B[pC%E|";

    boolean checkMMBI(ModelMBeanInfoSupport mmbi, String what) throws Exception {
        String bad = "";
        if (!(mmbi.getAttributes() instanceof ModelMBeanAttributeInfo[]))
            bad += " attributes";
        if (!(mmbi.getConstructors() instanceof ModelMBeanConstructorInfo[]))
            bad += " constructors";
        if (!(mmbi.getOperations() instanceof ModelMBeanOperationInfo[]))
            bad += " operations";
        if (!(mmbi.getNotifications() instanceof ModelMBeanNotificationInfo[]))
            bad += " notifications";
        if (bad.equals("")) {
            System.out.println("..." + what + ": OK");
            return true;
        } else {
            System.out.println("..." + what + ": FAILS for:" + bad);
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17279().checkMMBI(mmbi, what));
    }
}
