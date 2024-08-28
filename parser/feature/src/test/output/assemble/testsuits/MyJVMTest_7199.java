import java.util.*;

public class MyJVMTest_7199 {

    static List<T> l = new ArrayList<T>();

    <T> java.util.List<T> reverse(java.util.List<T> l) {
        java.util.List<T> r = new ArrayList<T>(l.size());
        for (T t : l) r.add(0, t);
        return r;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_7199().reverse(l));
    }
}
