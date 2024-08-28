import java.util.*;

public class MyJVMTest_16321 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_add_E() {
        System.err.println("test add(E)");
        for (List<String> l : examples.values()) {
            try {
                l.add("test");
                throw new AssertionError();
            } catch (UnsupportedOperationException ex) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16321().test_add_E();
    }
}
