import java.util.*;

public class MyJVMTest_15541 {

    static Map<java.util.List<String>, List<String>> examples = new HashMap<List<String>,List<String>>();

    void test_set_int_E() {
        System.err.println("test set(int,E)");
        for (List<String> l : examples.values()) {
            try {
                l.set(0, "X");
                throw new AssertionError();
            } catch (UnsupportedOperationException ex) {
            }
        }
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15541().test_set_int_E();
    }
}
