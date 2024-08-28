import java.util.*;

public class MyJVMTest_10908 {

    static Iterable<T> b = null;

    <T extends Integer> Iterable<T> g(Iterable<T> b) {
        for (int i : b) {
            System.out.println(i);
        }
        return b;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10908().g(b);
    }
}
