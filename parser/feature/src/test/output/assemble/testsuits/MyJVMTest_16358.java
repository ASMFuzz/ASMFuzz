import java.util.ArrayList;

public class MyJVMTest_16358 {

    static A head = null;

    static List<A> tail = new ArrayList<A>();

    boolean nonEmpty() {
        return tail != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_16358().nonEmpty());
    }
}
