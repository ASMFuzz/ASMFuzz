import java.util.*;

public class MyJVMTest_13686 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_retainAll_Collection() {
        System.err.println("test retainAll(Collection)");
        for (List<String> l : examples.values()) {
            int l_size = l.size();
            for (java.util.List<String> arg : examples.keySet()) {
                try {
                    boolean modified = l.retainAll(arg);
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
        new MyJVMTest_13686().test_retainAll_Collection();
    }
}
