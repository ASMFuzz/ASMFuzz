import java.util.*;

public class MyJVMTest_15558 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_remove_Object() {
        System.err.println("test remove(Object)");
        for (List<String> l : examples.values()) {
            boolean hasX = l.contains("X");
            try {
                l.remove("X");
                if (hasX)
                    throw new AssertionError();
            } catch (UnsupportedOperationException ex) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15558().test_remove_Object();
    }
}
