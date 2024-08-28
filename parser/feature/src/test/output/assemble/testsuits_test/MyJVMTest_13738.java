import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_13738 {

    static List<? super Object[]> l = new ArrayList<? super Object[]>();

    List<? super Object[]> foo(List<? super Object[]> l) {
        l.add(new Object[0]);
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13738().foo(l);
    }
}
