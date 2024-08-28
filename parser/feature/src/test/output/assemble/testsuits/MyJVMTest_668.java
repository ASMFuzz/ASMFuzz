import sun.misc.*;
import java.util.*;

public class MyJVMTest_668 {

    static int n = -1810664189;

    static Hashtable globalTable = new Hashtable();

    static int threadID = 2040441014, nObjects = 5;

    static Hashtable table = new Hashtable();

    Object doIt(int n) {
        Integer item = new Integer(n);
        return item;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_668().doIt(n));
    }
}
