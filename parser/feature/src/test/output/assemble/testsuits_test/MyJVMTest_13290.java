import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import javax.management.relation.*;

public class MyJVMTest_13290 {

    static Map<K, V> m = new HashMap<K, V>();

    static Class<K> keyType = null;

    static Class<V> valueType = null;

    <K, V> Map<K, V> checked(Map<K, V> m, Class<K> keyType, Class<V> valueType) {
        Map<K, V> unchecked = new HashMap<K, V>();
        Map<K, V> checked = Collections.checkedMap(unchecked, keyType, valueType);
        checked.putAll(m);
        return Collections.checkedMap(m, keyType, valueType);
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13290().checked(m, keyType, valueType).forEach((a, b) -> System.out.println(a + b));
    }
}
