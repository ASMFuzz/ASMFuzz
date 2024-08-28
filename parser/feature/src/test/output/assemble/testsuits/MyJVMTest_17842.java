import java.lang.reflect.Method;

public class MyJVMTest_17842 {

    static Class<?> declaringClass = null;

    static String name = "R5]e[Nre4K";

    static Class<?> parameterTypes = null;

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

    Method getDeclaredMethodOptional(Class<?> declaringClass, String name, Class<?>... parameterTypes) {
        try {
            return declaringClass.getDeclaredMethod(name, parameterTypes);
        } catch (NoSuchMethodException e) {
            return null;
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17842().getDeclaredMethodOptional(declaringClass, name, parameterTypes));
    }
}
