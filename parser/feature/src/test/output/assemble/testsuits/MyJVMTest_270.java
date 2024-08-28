import java.util.*;

public class MyJVMTest_270 {

    static Iterable<? extends Integer> b = null;

    Iterable<? extends Integer> h(Iterable<? extends Integer> b) {
        for (int i : b) {
            System.out.println(i);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_270().h(b);
    }
}
