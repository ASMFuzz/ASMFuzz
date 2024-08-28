import java.util.*;
import javax.management.*;

public class MyJVMTest_3833 {

    static int i = 0;

    static Class c = null;

    static String s = "9xc|wQNBmF";

    static String d = ":>{`Qoe%CL";

    static String k = "9,?%>+*=!s";

    static String v = "mYb|vt8=F[";

    static Hashtable<String, String> t = new Hashtable<String, String>();

    int createObjectName(int i, Class c, String s, String d, String k, String v, Hashtable<String, String> t) throws Exception {
        System.out.println("----------------------------------------------");
        switch(i) {
            case 1:
                System.out.println("ObjectName = " + s);
                break;
            case 2:
                System.out.println("ObjectName.Domain = " + d);
                System.out.println("ObjectName.Key = " + k);
                System.out.println("ObjectName.Value = " + v);
                break;
            case 3:
                System.out.println("ObjectName.Domain = " + d);
                System.out.println("ObjectName.Hashtable = " + t);
                break;
            default:
                throw new Exception("Test incorrect: case: " + i);
        }
        int error = 0;
        ObjectName on = null;
        try {
            switch(i) {
                case 1:
                    on = new ObjectName(s);
                    break;
                case 2:
                    on = new ObjectName(d, k, v);
                    break;
                case 3:
                    on = new ObjectName(d, t);
                    break;
                default:
                    throw new Exception("Test incorrect: case: " + i);
            }
            if (c != null) {
                error++;
                System.out.println("Got Unexpected ObjectName = " + (on == null ? "null" : on.getCanonicalName()));
            } else {
                System.out.println("Got Expected ObjectName = " + (on == null ? "null" : on.getCanonicalName()));
            }
        } catch (Exception e) {
            if (c == null || !c.isInstance(e)) {
                error++;
                System.out.println("Got Unexpected Exception = " + e.toString());
            } else {
                System.out.println("Got Expected Exception = " + e.toString());
            }
        }
        System.out.println("----------------------------------------------");
        return error;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_3833().createObjectName(i, c, s, d, k, v, t));
    }
}
