import java.util.*;

public class MyJVMTest_9266 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_equals_Object() {
        System.err.println("test equals(Object)");
        for (Map.Entry<java.util.List<String>, List<String>> e : examples.entrySet()) {
            java.util.List<String> ref = e.getKey();
            List<String> l = e.getValue();
            for (java.util.List<String> arg : examples.keySet()) {
                boolean expect = ref.equals(arg);
                boolean found = l.equals(arg);
                if (expect != found) {
                    System.err.println("ref: " + ref);
                    System.err.println("l: " + l);
                    System.err.println("arg: " + arg);
                    System.err.println("expect: " + expect + ", found: " + found);
                    throw new AssertionError();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9266().test_equals_Object();
    }
}
