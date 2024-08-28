import java.util.*;
import javax.imageio.spi.*;

public class MyJVMTest_10094 {

    static Class<T> clazz = null;

    static ClassLoader cl = ServiceRegistryRestriction.class.getClassLoader();

    <T> Class<T> lookup(Class<T> clazz) {
        Iterator<T> i = ServiceRegistry.lookupProviders(clazz);
        return clazz;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10094().lookup(clazz);
    }
}
