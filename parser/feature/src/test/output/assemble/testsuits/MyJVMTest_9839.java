import sun.misc.*;
import java.util.*;

public class MyJVMTest_9839 {

    static int n = 0;

    static Hashtable globalTable = new Hashtable();

    static int threadID = -1466583180, nObjects = 4;

    static Hashtable table = new Hashtable();

    Object doIt(int n) {
        Integer item = new Integer(n);
        return item;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_9839().doIt(n));
    }
}
