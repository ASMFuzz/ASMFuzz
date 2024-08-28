import java.util.*;

public class MyJVMTest_14081 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_add_int_E() {
        System.err.println("test add(int,E)");
        for (List<String> l : examples.values()) {
            try {
                l.add(0, "test");
                throw new AssertionError();
            } catch (UnsupportedOperationException ex) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_14081().test_add_int_E();
    }
}
