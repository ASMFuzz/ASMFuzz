import java.util.*;
import java.io.*;

public class MyJVMTest_11797 {

    static int i = 0;

    static Short e = 32767;

    List<Short> asList(final short[] a) {
        return new AbstractList<Short>() {

            public Short get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Short set(int i, Short e) {
                short oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_11797().set(i, e));
    }
}
