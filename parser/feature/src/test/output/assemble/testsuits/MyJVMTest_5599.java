import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_5599 {

    void foo() {
        List<Object[]> list = new ArrayList<Object[]>();
        Object o1 = list.get(0)[0];
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_5599().foo();
    }
}
