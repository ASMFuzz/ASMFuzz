public class MyJVMTest_9844 {

    static Class<?> cls = null;

    boolean testPlatformClassLoader(Class<?> cls) {
        ClassLoader loader = cls.getClassLoader();
        if (loader == null) {
            throw new RuntimeException(String.format("Loaded through Bootstrap Classloader: '%s'", cls));
        } else if (!loader.toString().contains("PlatformClassLoader")) {
            throw new RuntimeException(String.format("Not loaded through Platform ClassLoader: '%s'", cls));
        }
        System.out.println(String.format("Pass: '%s' get loaded through PlatformClassLoader", cls));
        return true;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9844().testPlatformClassLoader(cls));
    }
}
