import java.lang.reflect.*;
import java.util.*;
import javax.management.*;
import javax.management.openmbean.*;
import javax.management.relation.*;

public class MyJVMTest_11911 {

    static List<E> l1 = new ArrayList<E>();

    static List<E> l2 = new ArrayList<E>();

    <E> boolean equalListContents(List<E> l1, List<E> l2) {
        return new HashSet<E>(l1).equals(new HashSet<E>(l2));
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11911().equalListContents(l1, l2));
    }
}
