import java.util.ArrayList;

public class MyJVMTest_12102 {

    static A head = null;

    static List<A> tail = new ArrayList<A>();

    boolean isEmpty() {
        return tail == null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_12102().isEmpty());
    }
}
