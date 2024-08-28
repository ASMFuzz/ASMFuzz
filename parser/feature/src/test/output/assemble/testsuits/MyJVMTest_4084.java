import java.beans.Introspector;
import java.beans.MethodDescriptor;

public class MyJVMTest_4084 {

    static Class<?> type = null;

    static Class<?> bean = null;

    MethodDescriptor test(Class<?> type, Class<?> bean) throws Exception {
        for (MethodDescriptor md : Introspector.getBeanInfo(bean).getMethodDescriptors()) {
            if (md.getName().equals("getFoo")) {
                if (type != md.getMethod().getReturnType()) {
                    throw new Error("unexpected type");
                }
            }
        }
        return md;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4084().test(type, bean);
    }
}
