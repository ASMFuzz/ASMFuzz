import sun.misc.*;
import java.util.*;

public class MyJVMTest_10883 {

    static Object p1 = 0;

    static Object p2 = 1;

    static int p3 = 7;

    static Hashtable globalTable = new Hashtable();

    static String string1 = "^9a!T}YlU&", string2 = "vOcOYtRe4;";

    static int threadID = 3, nObjects = 5;

    static Hashtable table = new Hashtable();

    int init(Object p1, Object p2, int p3) {
        string1 = (String) p1;
        string2 = (String) p2;
        nObjects = p3;
        return p3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_10883().init(p1, p2, p3);
    }
}
