import java.util.*;

public class MyJVMTest_17175 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_contains_All() {
        System.err.println("test containsAll()");
        for (Map.Entry<java.util.List<String>, List<String>> e : examples.entrySet()) {
            java.util.List<String> ref = e.getKey();
            List<String> l = e.getValue();
            for (java.util.List<String> arg : examples.keySet()) {
                boolean expect = ref.containsAll(arg);
                boolean found = l.containsAll(arg);
                if (expect != found)
                    throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_17175().test_contains_All();
    }
}
