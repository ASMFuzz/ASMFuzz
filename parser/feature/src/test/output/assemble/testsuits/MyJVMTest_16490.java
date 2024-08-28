import java.util.*;

public class MyJVMTest_16490 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_remove_int() {
        System.err.println("test remove(int)");
        for (List<String> l : examples.values()) {
            try {
                l.remove(0);
                throw new AssertionError();
            } catch (UnsupportedOperationException ex) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16490().test_remove_int();
    }
}
