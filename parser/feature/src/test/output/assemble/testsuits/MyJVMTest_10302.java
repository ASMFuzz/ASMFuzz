import java.util.LinkedList;
import java.util.Arrays;

public class MyJVMTest_10302 {

    static int length = 3;

    static int count = -247084411;

    static LinkedList<char[]> buffers = new LinkedList<>();

    static boolean complete = false;

    char[] getNext(int length, int count) {
        if (this.buffers.isEmpty()) {
            return new char[100];
        }
        char[] b = (char[]) this.buffers.getFirst();
        if (count >= 100) {
            this.complete = true;
            this.buffers.clear();
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Arrays.asList(new MyJVMTest_10302().getNext(length, count)));
    }
}
