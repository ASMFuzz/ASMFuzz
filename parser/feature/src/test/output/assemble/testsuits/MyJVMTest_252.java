import sun.misc.*;
import java.util.*;

public class MyJVMTest_252 {

    static Object p1 = 1447136329;

    static Object p2 = -1941616103;

    static int p3 = -2035620225;

    static String string1 = "^tQ'd9JK3A", string2 = "-~?:kH0Zr%";

    static int threadID = 6, nObjects = 2;

    static Hashtable table = new Hashtable();

    int init(Object p1, Object p2, int p3) {
        string1 = (String) p1;
        string2 = (String) p2;
        nObjects = p3;
        return p3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_252().init(p1, p2, p3);
    }
}
