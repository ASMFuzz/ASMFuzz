import java.util.*;
import java.io.*;

public class MyJVMTest_10544 {

    static int i = 3;

    static Long e = 0;

    List<Long> asList(final long[] a) {
        return new AbstractList<Long>() {

            public Long get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Long set(int i, Long e) {
                long oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10544().set(i, e));
    }
}
