import java.util.List;
import java.util.ArrayList;

public class MyJVMTest_2602 {

    static List<? extends double[]> l = new ArrayList<? extends double[]>();

    List<? extends double[]> test(List<? extends double[]> l) {
        (true ? l.get(0) : l.get(0)).toString();
        return l;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2602().test(l);
    }
}
