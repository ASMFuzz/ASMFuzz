import javax.management.*;

public class MyJVMTest_7550 {

    static String n1Param1Param1 = "LH.JGO0j>|";

    static ObjectName n1Param1 = new ObjectName(n1Param1Param1);

    static String n1Param2 = "]Bbb=j}!1=";

    static ObjectInstance n1 = new ObjectInstance(n1Param1, n1Param2);

    static String n2Param1 = "D~x9[6:y..";

    static String n2Param2 = "1\\T^iv+5\"/";

    static ObjectInstance n2 = new ObjectInstance(n2Param1, n2Param2);

    ObjectInstance testEquals(ObjectInstance n1, ObjectInstance n2) {
        try {
            if (!n1.equals(n2) || !n2.equals(n1)) {
                System.err.println("Equals yields false for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]");
                System.exit(1);
            }
        } catch (Exception x) {
            System.err.println("Equals failed for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]: " + x);
            x.printStackTrace();
            System.exit(2);
        }
        try {
            if (n1.hashCode() != n2.hashCode()) {
                System.err.println("Different hashCode() for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]");
                System.exit(3);
            }
        } catch (Exception x) {
            System.err.println("Hashcode failed for: " + "[" + n1.getObjectName() + " , " + n1.getClassName() + "] [" + n2.getObjectName() + " , " + n2.getClassName() + "]: " + x);
            x.printStackTrace();
            System.exit(4);
        }
        return n2;
    }

    public static void main(String[] args) throws Exception {
        new MyJVMTest_7550().testEquals(n1, n2);
    }
}
