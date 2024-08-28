import java.util.*;

public class MyJVMTest_9254 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_clear() {
        System.err.println("test clear()");
        for (List<String> l : examples.values()) {
            int l_size = l.size();
            try {
                l.clear();
                if (l_size > 0)
                    throw new AssertionError();
            } catch (UnsupportedOperationException e) {
            }
            if (l.size() != l_size)
                throw new AssertionError();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9254().test_clear();
    }
}
