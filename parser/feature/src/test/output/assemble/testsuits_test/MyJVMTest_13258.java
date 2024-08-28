import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_13258 {

    static List l2 = new ArrayList();

    List m(@SuppressWarnings("rawtypes") List l2) {
        @SuppressWarnings("rawtypes")
        List l3;
        return l3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_13258().m(l2);
    }
}
