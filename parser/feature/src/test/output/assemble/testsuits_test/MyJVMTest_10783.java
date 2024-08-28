import javax.management.modelmbean.*;
import java.lang.reflect.Method;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanException;
import javax.management.MBeanServer;

public class MyJVMTest_10783 {

    static int tally = 0;

    ModelMBeanInfo createModelMBeanInfo() throws Exception {
        String descriptionOp1Set = "ManagedResource description setter";
        Class[] paramsSet1 = { Class.forName("java.lang.Object"), Class.forName("java.lang.String") };
        Method oper1Set = RequiredModelMBean.class.getMethod("setManagedResource", paramsSet1);
        ModelMBeanOperationInfo operation1Set = new ModelMBeanOperationInfo(descriptionOp1Set, oper1Set);
        String descriptionop2Set = "addAttributeChangeNotificationListener description";
        Class[] paramsSet2 = { Class.forName("javax.management.NotificationListener"), Class.forName("java.lang.String"), Class.forName("java.lang.Object") };
        Method oper2Set = RequiredModelMBean.class.getMethod("addAttributeChangeNotificationListener", paramsSet2);
        ModelMBeanOperationInfo operation2Set = new ModelMBeanOperationInfo(descriptionop2Set, oper2Set);
        String className = "ModelMBeansInfo";
        String descriptionmodel = "Model MBean Test";
        ModelMBeanAttributeInfo[] attributes = null;
        ModelMBeanOperationInfo[] operations = { operation1Set, operation2Set };
        ModelMBeanNotificationInfo[] notifications = null;
        ModelMBeanConstructorInfo[] constructors = null;
        ModelMBeanInfoSupport modelMBeanInfo = new ModelMBeanInfoSupport(className, descriptionmodel, attributes, constructors, operations, notifications);
        return modelMBeanInfo;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10783().createModelMBeanInfo());
    }
}
