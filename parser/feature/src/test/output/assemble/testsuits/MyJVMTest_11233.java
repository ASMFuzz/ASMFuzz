import java.util.*;

public class MyJVMTest_11233 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_indexOf_Object() {
        System.err.println("test indexOf(Object)");
        for (Map.Entry<java.util.List<String>, List<String>> e : examples.entrySet()) {
            java.util.List<String> ref = e.getKey();
            List<String> l = e.getValue();
            for (int i = -1; i < ref.size(); i++) {
                String arg = (i == -1 ? "NOT IN LIST" : ref.get(i));
                int expect = ref.indexOf(arg);
                int found = l.indexOf(arg);
                if (expect != found)
                    throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11233().test_indexOf_Object();
    }
}
