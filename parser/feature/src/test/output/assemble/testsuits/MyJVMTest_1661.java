import sun.misc.*;
import java.util.*;

public class MyJVMTest_1661 {

    static Object p1 = 0;

    static Object p2 = 3;

    static int p3 = 9;

    static Hashtable globalTable = new Hashtable();

    static String string1 = "AK#Vjss$=P", string2 = "5Vkc70CcR|";

    static int threadID = 0, nObjects = 4;

    static Hashtable table = new Hashtable();

    int init(Object p1, Object p2, int p3) {
        string1 = (String) p1;
        string2 = (String) p2;
        nObjects = p3;
        return p3;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_1661().init(p1, p2, p3);
    }
}
