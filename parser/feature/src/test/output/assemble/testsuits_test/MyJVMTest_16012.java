import java.util.*;

public class MyJVMTest_16012 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_addAll_int_Collection() {
        System.err.println("test addAll(int,Collection)");
        for (List<String> l : examples.values()) {
            int l_size = l.size();
            for (java.util.List<String> arg : examples.keySet()) {
                try {
                    boolean modified = l.addAll(0, arg);
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
        new MyJVMTest_16012().test_addAll_int_Collection();
    }
}
