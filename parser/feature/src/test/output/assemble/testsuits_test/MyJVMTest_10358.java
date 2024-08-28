import java.util.*;
import java.io.*;

public class MyJVMTest_10358 {

    static int i = 0;

    static Double e = Double.MAX_VALUE;

    List<Double> asList(final double[] a) {
        return new AbstractList<Double>() {

            public Double get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Double set(int i, Double e) {
                Double oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_10358().set(i, e));
    }
}
