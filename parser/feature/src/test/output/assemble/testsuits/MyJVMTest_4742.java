import java.util.LinkedList;
import java.util.List;

public class MyJVMTest_4742 {

    void t() {
        List<String> l1 = new LinkedList<String>();
        final List<String> l2 = new LinkedList<String>();
        @Deprecated
        List<String> l3 = new LinkedList<String>();
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_4742().t();
    }
}
