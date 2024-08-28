import java.lang.invoke.*;
import java.util.*;

public class MyJVMTest_10225 {

    static Class<?> from = null;

    static Class<?> to = null;

    static Map<Class<?>, Set<Class<?>>> pairs = new HashMap<>();

    Class<?> put(Class<?> from, Class<?> to) {
        Set<Class<?>> set = pairs.computeIfAbsent(from, f -> new HashSet<>());
        set.add(to);
        return to;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10225().put(from, to);
    }
}
