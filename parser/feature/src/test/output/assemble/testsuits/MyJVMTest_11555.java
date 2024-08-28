import java.util.*;
import java.io.*;

public class MyJVMTest_11555 {

    static int i = 5;

    static Boolean e = true;

    List<Boolean> asList(final boolean[] a) {
        return new AbstractList<Boolean>() {

            public Boolean get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Boolean set(int i, Boolean e) {
                Boolean oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11555().set(i, e));
    }
}
