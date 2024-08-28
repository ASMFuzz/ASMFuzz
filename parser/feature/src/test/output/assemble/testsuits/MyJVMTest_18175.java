import java.util.*;

public class MyJVMTest_18175 {

    static String id = "=vL>X&$-.!";

    static int ord = 0;

    static ClassLoaderType prev = null;

    static ClassLoaderType next = null;

    static int upperBound = 0;

    static ClassLoaderType first = null;

    static ClassLoaderType last = null;

    static ClassLoaderType curr = first;

    boolean hasMoreElements() {
        return curr != null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_18175().hasMoreElements());
    }
}
