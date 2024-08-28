import java.util.Hashtable;
import javax.management.ObjectName;

public class MyJVMTest_6674 {

    static int i = 0;

    static String s = "QXTSs`_,'+";

    static String d = "m_r2[~Toa:";

    static String k = "K8Ur0&uccg";

    static String v = ":&mMxB|!x=";

    static Hashtable<String, String> t = new Hashtable<String, String>();

    static boolean plp = false;

    static boolean pvp = false;

    int createObjectName(int i, String s, String d, String k, String v, Hashtable<String, String> t, boolean plp, boolean pvp) throws Exception {
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
            System.out.println("Got Expected ObjectName = " + on.getCanonicalName());
            boolean isPattern = on.isPattern();
            boolean isDomainPattern = on.isDomainPattern();
            boolean isPropertyPattern = on.isPropertyPattern();
            boolean isPropertyListPattern = on.isPropertyListPattern();
            boolean isPropertyValuePattern = on.isPropertyValuePattern();
            System.out.println("ObjectName.isPattern = " + isPattern);
            System.out.println("ObjectName.isDomainPattern = " + isDomainPattern);
            System.out.println("ObjectName.isPropertyPattern = " + isPropertyPattern);
            System.out.println("ObjectName.isPropertyListPattern = " + isPropertyListPattern);
            System.out.println("ObjectName.isPropertyValuePattern = " + isPropertyValuePattern);
            int error2 = 0;
            if (isDomainPattern) {
                error2++;
                System.out.println("Error: Shouldn't be domain pattern!");
            }
            if (!plp && isPropertyListPattern) {
                error2++;
                System.out.println("Error: Shouldn't be property list pattern!");
            }
            if (!pvp && isPropertyValuePattern) {
                error2++;
                System.out.println("Error: Shouldn't be property value pattern!");
            }
            if (plp && !isPattern && !isPropertyPattern && !isPropertyListPattern) {
                error2++;
                System.out.println("Error: Should be property list pattern!");
            }
            if (pvp && !isPattern && !isPropertyPattern && !isPropertyValuePattern) {
                error2++;
                System.out.println("Error: Should be property value pattern!");
            }
            if (error2 > 0) {
                error++;
                System.out.println("Test failed!");
            } else {
                System.out.println("Test passed!");
            }
        } catch (Exception e) {
            error++;
            System.out.println("Got Unexpected Exception = " + e.toString());
        }
        System.out.println("----------------------------------------------");
        return error;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new MyJVMTest_6674().createObjectName(i, s, d, k, v, t, plp, pvp));
    }
}
