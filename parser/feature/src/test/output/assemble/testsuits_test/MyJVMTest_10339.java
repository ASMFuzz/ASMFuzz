import java.util.*;
import java.io.*;

public class MyJVMTest_10339 {

    static int i = -1929089230;

    static Float e = 0.7882975f;

    List<Float> asList(final float[] a) {
        return new AbstractList<Float>() {

            public Float get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Float set(int i, Float e) {
                Float oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10339().set(i, e));
    }
}
