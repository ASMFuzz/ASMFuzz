import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import javax.management.relation.*;

public class MyJVMTest_17278 {

    static List<E> c = new ArrayList<E>();

    static Class<E> type = null;

    <E> List<E> checked(List<E> c, Class<E> type) {
        List<E> unchecked = new ArrayList<E>();
        List<E> checked = Collections.checkedList(unchecked, type);
        checked.addAll(c);
        return Collections.checkedList(c, type);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_17278().checked(c, type));
    }
}
