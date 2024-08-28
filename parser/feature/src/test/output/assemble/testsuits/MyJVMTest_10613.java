import java.util.*;

public class MyJVMTest_10613 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_isEmpty() {
        System.err.println("test isEmpty()");
        for (Map.Entry<java.util.List<String>, List<String>> e : examples.entrySet()) {
            java.util.List<String> ref = e.getKey();
            List<String> l = e.getValue();
            boolean expect = ref.isEmpty();
            boolean found = l.isEmpty();
            if (expect != found)
                throw new AssertionError();
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10613().test_isEmpty();
    }
}
