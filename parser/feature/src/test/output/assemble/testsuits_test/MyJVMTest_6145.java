import java.util.*;

public class MyJVMTest_6145 {

    void test_AbstractList() {
        System.err.println("test AbstractList");
        if (AbstractList.class.isAssignableFrom(List.class))
            throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6145().test_AbstractList();
    }
}
