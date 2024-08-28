import java.util.ArrayList;
import java.util.List;

public class MyJVMTest_3609 {

    static int NODE_COUNT = Integer.getInteger("nodes", 10000);

    Object createSome() {
        List<Integer> result = new ArrayList<Integer>();
        for (int c = 0; c < NODE_COUNT; c++) {
            result.add(new Integer(c));
        }
        return result;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3609().createSome());
    }
}
