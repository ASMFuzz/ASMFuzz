import java.util.HashMap;
import java.util.Map;

public class MyJVMTest_42 {

    static Map<String, Class<?>> classCache = new HashMap<>();

    Map<String, Class<?>> getClassCache() {
        if (classCache.isEmpty()) {
            classCache = new HashMap<String, Class<?>>();
        }
        return classCache;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_42().getClassCache().forEach((a, b) -> System.out.println(a + b));
    }
}
