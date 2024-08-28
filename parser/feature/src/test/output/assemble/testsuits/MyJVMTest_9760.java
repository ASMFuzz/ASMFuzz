import java.lang.reflect.Method;

public class MyJVMTest_9760 {

    static Class<?> cls = null;

    static Object realModule = 6;

    static Class<?> moduleClass = null;

    static Class<?> layerClass = null;

    static Method bootMethod = null;

    static Method modulesMethod = null;

    static Method getModuleMethod = null;

    static Method getUnnamedModuleMethod = null;

    static Method getNameMethod = null;

    static Method getPackagesMethod = null;

    static Method isExportedMethod = null;

    static Method isExported2Method = null;

    static Method addExportsMethod = null;

    static Method addOpensMethod = null;

    JLModule fromClass(Class<?> cls) {
        try {
            return new JLModule(getModuleMethod.invoke(cls));
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9760().fromClass(cls));
    }
}
