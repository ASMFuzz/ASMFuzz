import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import javax.management.relation.*;

public class MyJVMTest_12150 {

    static Set<E> c = new HashSet<E>();

    static Class<E> type = null;

    <E> Set<E> checked(Set<E> c, Class<E> type) {
        Set<E> unchecked = new HashSet<E>();
        Set<E> checked = Collections.checkedSet(unchecked, type);
        checked.addAll(c);
        return Collections.checkedSet(c, type);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12150().checked(c, type));
    }
}
