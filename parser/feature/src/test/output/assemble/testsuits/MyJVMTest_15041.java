import java.util.LinkedList;

public class MyJVMTest_15041 {

    static LinkedList<char[]> buffers = new LinkedList<>();

    boolean availableSegment() {
        return (buffers.isEmpty() == false);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_15041().availableSegment());
    }
}
