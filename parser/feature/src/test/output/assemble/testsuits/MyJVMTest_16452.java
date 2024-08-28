import java.util.*;

public class MyJVMTest_16452 {

    static Integer[] a = { 130158983, 0, 4, -1530377686, 196127470, 6, 0, 1649990498, 3, 4 };

    Integer[] f(Integer[] a) {
        for (int i : a) {
            System.out.println(i);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_16452().f(a);
    }
}
