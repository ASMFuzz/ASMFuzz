import java.util.*;
import java.io.*;

public class MyJVMTest_11982 {

    static int i = 0;

    static Integer e = 9;

    List<Integer> asList(final int[] a) {
        return new AbstractList<Integer>() {

            public Integer get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Integer set(int i, Integer e) {
                int oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11982().set(i, e));
    }
}
