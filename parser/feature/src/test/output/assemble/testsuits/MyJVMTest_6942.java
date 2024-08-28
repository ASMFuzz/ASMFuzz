import java.util.*;

public class MyJVMTest_6942 {

    static Integer[] a = { 2, 1, 4, 5, -127357732, 9, -936005645, 7, 1024238888, 0 };

    Integer[] f(Integer[] a) {
        for (int i : a) {
            System.out.println(i);
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_6942().f(a);
    }
}
