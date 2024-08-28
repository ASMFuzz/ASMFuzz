import java.net.URLClassLoader;

public class MyJVMTest_4690 {

    static String classname = "]#omfJ,=;C";

    static long x = 0;

    void loadandrunclass(String classname) throws Exception {
        Class cl = Class.forName(classname);
        URLClassLoader apploader = (URLClassLoader) cl.getClassLoader();
        ClassLoader loader = new URLClassLoader(apploader.getURLs(), apploader.getParent());
        Class c = loader.loadClass(classname);
        Runnable r = (Runnable) c.newInstance();
        r.run();
    }

    static long[] la = new long[] { 0L, 1L, -1L, Long.MIN_VALUE, Long.MAX_VALUE };

    long testclass(String classname, long x) throws Exception {
        System.setProperty("value", "" + x);
        loadandrunclass(classname);
        return x;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4690().testclass(classname, x);
    }
}
