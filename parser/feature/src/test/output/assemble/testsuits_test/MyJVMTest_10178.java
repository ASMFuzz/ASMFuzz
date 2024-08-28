import java.util.*;

public class MyJVMTest_10178 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_size() {
        System.err.println("test size()");
        for (Map.Entry<java.util.List<String>, List<String>> e : examples.entrySet()) {
            java.util.List<String> ref = e.getKey();
            List<String> l = e.getValue();
            int expect = ref.size();
            int found = l.size();
            if (expect != found)
                throw new AssertionError();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10178().test_size();
    }
}
