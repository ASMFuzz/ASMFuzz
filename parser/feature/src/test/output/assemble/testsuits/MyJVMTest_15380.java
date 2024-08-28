import java.util.*;

public class MyJVMTest_15380 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_contains_Object() {
        System.err.println("test contains(Object)");
        for (Map.Entry<java.util.List<String>, List<String>> e : examples.entrySet()) {
            java.util.List<String> ref = e.getKey();
            List<String> l = e.getValue();
            boolean expect = ref.contains("1");
            boolean found = l.contains("1");
            if (expect != found)
                throw new AssertionError();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15380().test_contains_Object();
    }
}
