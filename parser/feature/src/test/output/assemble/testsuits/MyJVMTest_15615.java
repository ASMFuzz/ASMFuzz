import java.util.*;

public class MyJVMTest_15615 {

    void test_AbstractList() {
        System.err.println("test AbstractList");
        if (AbstractList.class.isAssignableFrom(List.class))
            throw new AssertionError();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_15615().test_AbstractList();
    }
}
