import java.lang.reflect.Method;

public class MyJVMTest_3215 {

    static Object realModule = 0;

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

    Class<?> findModuleClass() throws ClassNotFoundException {
        try {
            return Class.forName("java.lang.Module");
        } catch (ClassNotFoundException e) {
            return Class.forName("java.lang.reflect.Module");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3215().findModuleClass());
    }
}
