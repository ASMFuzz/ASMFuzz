import java.util.*;

public class MyJVMTest_9288 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_addAll_Collection() {
        System.err.println("test addAll(Collection)");
        for (List<String> l : examples.values()) {
            int l_size = l.size();
            for (java.util.List<String> arg : examples.keySet()) {
                try {
                    boolean modified = l.addAll(arg);
                    if (modified)
                        throw new AssertionError();
                } catch (UnsupportedOperationException e) {
                }
                if (l.size() != l_size)
                    throw new AssertionError();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9288().test_addAll_Collection();
    }
}
