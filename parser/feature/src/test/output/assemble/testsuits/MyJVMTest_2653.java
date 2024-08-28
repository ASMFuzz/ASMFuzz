import java.util.*;

public class MyJVMTest_2653 {

    static int[] c = { -635079672, 0, 0, 3, 5, 7, -1840269572, 0, 9, 0 };

    int[] f(int[] c) {
        for (Integer i : c) {
            System.out.println(i);
        }
        return c;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_2653().f(c);
    }
}
