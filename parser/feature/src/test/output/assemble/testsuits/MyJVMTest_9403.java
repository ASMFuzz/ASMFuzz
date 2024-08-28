import sun.misc.*;
import java.util.*;

public class MyJVMTest_9403 {

    static Object p1 = 6;

    static Object p2 = -75523082;

    static int p3 = 2050187369;

    static String string1 = "Es>;G3k8`~", string2 = "%:06ibF!=S";

    static int threadID = 36215376, nObjects = 4;

    static Hashtable table = new Hashtable();

    int init(Object p1, Object p2, int p3) {
        string1 = (String) p1;
        string2 = (String) p2;
        nObjects = p3;
        return p3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_9403().init(p1, p2, p3);
    }
}
