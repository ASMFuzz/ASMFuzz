import java.lang.reflect.Method;

public class MyJVMTest_8266 {

    static Class<?> declaringClass = null;

    static String name = "~T=ZgsvSCM";

    static Class<?> parameterTypes = null;

    static Object realModule = 5;

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
        System.out.println(new MyJVMTest_8266().getDeclaredMethodOptional(declaringClass, name, parameterTypes));
    }
}
