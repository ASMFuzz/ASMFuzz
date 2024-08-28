import java.util.*;

public class MyJVMTest_11661 {

    void test() {
        String[] sa = null;
        List<String> ls = sa == null ? Arrays.asList(sa) : Collections.emptyList();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_11661().test();
    }
}
