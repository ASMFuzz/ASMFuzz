import java.io.*;
import java.net.*;

public class MyJVMTest_17729 {

    static String[] args = { "_Z?%G\"$wE5", "]i:+7;{$r%", "%*_-BZ)SlQ", "(2\"f/Jo>Vz", "Jb0LUiVb$>", "NWpIP6;CO*", "{@Tc;9?&b6", "_vjlv8y/8>", "YosJyoIQ0'", "%??Z< X'-G" };

    static ClassLoader[] loaders = { null, null, null, null, null, null, null, null, null, null };

    static int NUM_THREADS = 4;

    static int SYSTEM_LOADER = 0;

    static int SINGLE_CUSTOM_LOADER = 1;

    static int MULTI_CUSTOM_LOADER = 2;

    static int FINGERPRINT_MODE = 1;

    static int API_MODE = 2;

    static int loaderType = SYSTEM_LOADER;

    static ClassLoader[] classLoaders = {null,null,null,null,null,null,null,null,null,null};

    static int mode = FINGERPRINT_MODE;

    static float timeoutFactor = Float.parseFloat(System.getProperty("test.timeout.factor", "1.0"));

    String[] run(String[] args, ClassLoader[] loaders) throws Throwable {
        String customJar = null;
        System.out.println("ParallelLoad: timeoutFactor = " + timeoutFactor);
        if (args.length >= 1) {
            if ("SINGLE_CUSTOM_LOADER".equals(args[0])) {
                loaderType = SINGLE_CUSTOM_LOADER;
                customJar = args[2];
            } else if ("MULTI_CUSTOM_LOADER".equals(args[0])) {
                loaderType = MULTI_CUSTOM_LOADER;
                customJar = args[2];
            } else if ("SYSTEM_LOADER".equals(args[0])) {
                loaderType = SYSTEM_LOADER;
            } else {
                throw new RuntimeException("Unexpected loaderType" + args[0]);
            }
        }
        if (customJar != null) {
            if ("FINGERPRINT_MODE".equals(args[1])) {
                mode = FINGERPRINT_MODE;
                classLoaders = new ClassLoader[NUM_THREADS];
                for (int i = 0; i < NUM_THREADS; i++) {
                    URL url = new File(customJar).toURI().toURL();
                    URL[] urls = new URL[] { url };
                    classLoaders[i] = new URLClassLoader(urls);
                }
            } else {
                mode = API_MODE;
                classLoaders = loaders;
            }
        }
        System.out.println("Start Parallel Load ...");
        Thread[] thread = new Thread[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            Thread t = new ParallelLoadThread(i);
            t.start();
            thread[i] = t;
        }
        Thread watchdog = new ParallelLoadWatchdog();
        watchdog.setDaemon(true);
        watchdog.start();
        for (int i = 0; i < NUM_THREADS; i++) {
            thread[i].join();
        }
        System.out.println("Parallel Load ... done");
        System.exit(0);
        return args;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17729().run(args, loaders);
    }
}
