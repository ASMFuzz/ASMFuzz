import java.lang.reflect.Method;

public class MyJVMTest_2471 {

    static Object realModule = 2;

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

    Class<?> findModuleLayerClass() throws ClassNotFoundException {
        try {
            return Class.forName("java.lang.ModuleLayer");
        } catch (ClassNotFoundException e) {
            return Class.forName("java.lang.reflect.Layer");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_2471().findModuleLayerClass());
    }
}
