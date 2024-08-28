import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_3914 {

    static List l2 = new ArrayList();

    List m(@SuppressWarnings("rawtypes") List l2) {
        @SuppressWarnings("rawtypes")
        List l3;
        return l3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_3914().m(l2);
    }
}
