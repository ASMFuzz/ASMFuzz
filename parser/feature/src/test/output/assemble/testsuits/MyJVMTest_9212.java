import java.util.*;
import javax.tools.*;

public class MyJVMTest_9212 {

    static List<T> a = new ArrayList<T>();

    static List<T> b = new ArrayList<T>();

    <T> List<T> join(List<T> a, List<T> b) {
        if (a.isEmpty())
            return b;
        if (b.isEmpty())
            return a;
        List<T> result = new ArrayList<>();
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9212().join(a, b));
    }
}
