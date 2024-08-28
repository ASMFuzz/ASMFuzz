import java.util.*;
import java.io.*;

public class MyJVMTest_13123 {

    static int i = -1624220753;

    static Byte e = 0;

    List<Byte> asList(final byte[] a) {
        return new AbstractList<Byte>() {

            public Byte get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Byte set(int i, Byte e) {
                Byte oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_13123().set(i, e));
    }
}
