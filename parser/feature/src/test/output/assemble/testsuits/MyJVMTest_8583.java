import java.util.*;

public class MyJVMTest_8583 {

    static String id = ":fL\"ZUVS.O";

    static int ord = 8;

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
        System.out.println(new MyJVMTest_8583().hasMoreElements());
    }
}
