import java.lang.reflect.Method;

public class MyJVMTest_7016 {

    static String pn = "qn*Jy\\+{FJ";

    static Object realModule = -734837186;

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

    boolean isExported(String pn) {
        try {
            return (Boolean) isExportedMethod.invoke(realModule, pn);
        } catch (Exception e) {
            throw new AssertionError(e);
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7016().isExported(pn));
    }
}
