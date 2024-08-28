import java.lang.instrument.*;
import java.net.*;
import java.io.*;
import java.security.*;

public class MyJVMTest_9825 {

    static int index = -604973413;

    ClassLoader getClassLoader() {
        return sClassLoader;
    }

    static ClassLoader sClassLoader = null;

    int loadClasses(int index) {
        ClassLoader loader = ParallelTransformerLoaderAgent.getClassLoader();
        try {
            Class.forName("TestClass" + index, true, loader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return index;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9825().loadClasses(index);
    }
}
