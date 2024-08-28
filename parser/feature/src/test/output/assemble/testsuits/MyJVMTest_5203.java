public class MyJVMTest_5203 {

    static String mbeanName = "44evM}AcmD";

    static Object impl = 1;

    static String implPackageName = "com.sun.management.internal";

    Object check(String mbeanName, Object impl) {
        if (!impl.getClass().getName().startsWith(implPackageName)) {
            throw new RuntimeException(mbeanName + " implementation package " + "should be: " + implPackageName + ", but got: " + impl.getClass());
        } else {
            System.out.println("--- Good, " + mbeanName + " got right implementation: " + impl);
        }
        return impl;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5203().check(mbeanName, impl);
    }
}
