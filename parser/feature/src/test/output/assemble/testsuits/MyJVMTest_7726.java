import java.util.*;
import javax.management.modelmbean.*;

public class MyJVMTest_7726 {

    static String mmbiParam1 = "Hp3q2iMP~V";

    static String mmbiParam2 = "'(nx@dvrJ_";

    static ModelMBeanAttributeInfo[] mmbiParam3 = { null, null, null, null, null, null, null, null, null, null };

    static ModelMBeanConstructorInfo[] mmbiParam4 = { null, null, null, null, null, null, null, null, null, null };

    static ModelMBeanOperationInfo[] mmbiParam5 = { null, null, null, null, null, null, null, null, null, null };

    static ModelMBeanNotificationInfo[] mmbiParam6 = { null, null, null, null, null, null, null, null, null, null };

    static ModelMBeanInfoSupport mmbi = new ModelMBeanInfoSupport(mmbiParam1, mmbiParam2, mmbiParam3, mmbiParam4, mmbiParam5, mmbiParam6);

    static String what = "etVb#hL,p>";

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
        System.out.println(new MyJVMTest_7726().checkMMBI(mmbi, what));
    }
}
