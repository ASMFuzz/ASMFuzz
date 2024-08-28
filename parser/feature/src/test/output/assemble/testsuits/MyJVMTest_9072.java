import java.util.*;

public class MyJVMTest_9072 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_hashCode() {
        System.err.println("test hashCode()");
        for (Map.Entry<java.util.List<String>, List<String>> e : examples.entrySet()) {
            java.util.List<String> ref = e.getKey();
            List<String> l = e.getValue();
            long expect = ref.hashCode();
            long found = l.hashCode();
            if (expect != found) {
                System.err.println("ref: " + ref);
                System.err.println("l: " + l);
                System.err.println("expect: " + expect);
                System.err.println("found: " + found);
                throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9072().test_hashCode();
    }
}
