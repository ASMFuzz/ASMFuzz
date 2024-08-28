import sun.misc.*;
import java.util.*;

public class MyJVMTest_5208 {

    static int n = 8;

    static int threadID = -351343393, nObjects = 0;

    static Hashtable table = new Hashtable();

    Object doIt(int n) {
        Integer item = new Integer(n);
        return item;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_5208().doIt(n));
    }
}
