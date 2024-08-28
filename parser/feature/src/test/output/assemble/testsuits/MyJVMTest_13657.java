import java.util.*;

public class MyJVMTest_13657 {

    static Map<?, ?> m = new HashMap<?, ?>();

    Map<?, ?> f(Map<?, ?> m) {
        for (Map.Entry e : m.entrySet()) {
        }
        return m;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13657().f(m);
    }
}
