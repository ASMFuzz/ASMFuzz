import java.util.*;
import java.io.*;

public class MyJVMTest_9590 {

    static int i = 0;

    static Character e = Character.MAX_VALUE;

    List<Character> asList(final char[] a) {
        return new AbstractList<Character>() {

            public Character get(int i) {
                return a[i];
            }

            public int size() {
                return a.length;
            }

            public Character set(int i, Character e) {
                Character oldVal = a[i];
                a[i] = e;
                return oldVal;
            }
        };
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9590().set(i, e));
    }
}
