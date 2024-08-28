import java.io.*;
import java.util.*;
import java.util.jar.*;

public class MyJVMTest_13664 {

    static Set<T> a = new HashSet<T>();

    static Set<T> b = new HashSet<T>();

    <T> Set<T> diff(Set<T> a, Set<T> b) {
        if (b.isEmpty())
            return a;
        Set<T> result = new LinkedHashSet<T>(a);
        result.removeAll(b);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13664().diff(a, b));
    }
}
