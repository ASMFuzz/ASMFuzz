import java.util.*;
import javax.imageio.spi.*;

public class MyJVMTest_11948 {

    static Class<T> clazz = null;

    static ClassLoader cl = ServiceRegistryRestriction.class.getClassLoader();

    <T> Class<T> lookupCL(Class<T> clazz) {
        Iterator<T> i = ServiceRegistry.lookupProviders(clazz, cl);
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11948().lookupCL(clazz);
    }
}
